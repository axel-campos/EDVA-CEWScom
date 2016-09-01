<%-- 
    Document   : informacionProfesor
    Created on : 23/08/2016, 07:01:35 PM
    Author     : Víctor
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información del profesor</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-body">
                    <%
                        String nombre = "", cedula = "No hay información de la cedula", reportesUsuario = "", reportesGrupo = "", reportesContenido = "";
                        int numReportesUsuario = 0, numReportesGrupo = 0, numReportesContenido = 0;
                        String correo = (String)request.getParameter("correo");
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        
                        String query = "SELECT CONCAT_WS(' ',u.nombre,u.aPaterno,u.aMaterno) AS nombre, u.cedula, r.causa, r.fechaReporte, " +
                            "(SELECT COUNT(*) FROM reporte r2 WHERE r2.correo = u.correo) AS numReportes, " +
                            " '1' AS tipo " +
                            "FROM Usuario u " +
                            "LEFT JOIN reporte r ON r.correo = u.correo " +
                            "WHERE u.correo = '" + correo + "' " +
                            "UNION " +
                            "SELECT CONCAT_WS(' ',u.nombre,u.aPaterno,u.aMaterno) AS nombre, u.cedula, r.causa, r.fechaReporte, " +
                            "(SELECT COUNT(*) FROM reporte r2 WHERE r2.token IN (SELECT ug.token FROM usuariogrupo ug WHERE ug.correo = '" + correo + "')) AS numReportes, " +
                            "'2' AS tipo " +
                            "FROM Usuario u " +
                            "LEFT JOIN reporte r ON r.token IN (SELECT ug2.token FROM usuariogrupo ug2 WHERE ug2.correo = u.correo) " +
                            "WHERE u.correo = '" + correo + "' " +
                            "UNION " +
                            "SELECT CONCAT_WS(' ',u.nombre,u.aPaterno,u.aMaterno) AS nombre, u.cedula, r.causa, r.fechaReporte, " +
                            "(SELECT COUNT(*) FROM reporte r2 WHERE r2.idContenido IN " +
                            "(SELECT c2.idContenido FROM contenido c2 WHERE c2.token IN (SELECT ug2.token FROM usuariogrupo ug2 WHERE ug2.correo = '" + correo + "'))) AS numReportes, " +
                            "'3' AS tipo " +
                            "FROM Usuario u " +
                            "LEFT JOIN reporte r ON r.idContenido IN " +
                            "(SELECT c.idContenido FROM contenido c WHERE c.token IN (SELECT ug2.token FROM usuariogrupo ug2 WHERE ug2.correo = '" + correo + "')) " +
                            "WHERE u.correo = '" + correo + "'";
                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            usuarioDAO.conectar();
                            List<Map<String, Object>> informacion = usuarioDAO.consultaGenerica(query);
                            for(Map<String,Object> elemento: informacion ){  
                                nombre = (String)elemento.get("nombre");
                                if(elemento.get("cedula") != null){
                                    cedula = (String)elemento.get("cedula");
                                }
                                int tipo = Integer.parseInt((String)elemento.get("tipo"));
                                if(tipo == 1){
                                    numReportesUsuario = Integer.parseInt(String.valueOf(elemento.get("numReportes")));
                                    if(numReportesUsuario != 0){
                                        reportesUsuario = "<h5>Fecha: " + df.format((Timestamp)elemento.get("fechaReporte")) + " debido a: " + (String)elemento.get("causa") + "<h5>";
                                    }
                                }else if(tipo == 2){
                                    numReportesGrupo = Integer.parseInt(String.valueOf(elemento.get("numReportes")));
                                    if(numReportesGrupo != 0){
                                        reportesGrupo = "<h5>Fecha: " + df.format((Timestamp)elemento.get("fechaReporte")) + " debido a: " + (String)elemento.get("causa") + "</h5>";
                                    }
                                }else if(tipo == 3){
                                    numReportesContenido = Integer.parseInt(String.valueOf(elemento.get("numReportes")));
                                    if(numReportesContenido != 0){
                                        reportesContenido = "<h5>Fecha: " + df.format((Timestamp)elemento.get("fechaReporte")) + " debido a: " + (String)elemento.get("causa") + "</h5>";
                                    }
                                }
                            }
                        %>
                    <h5>Nombre: <%=nombre%></h5>
                    <h5>Correo: <%=correo%></h5>
                    <h5>Cedula: <%=cedula%></h5>
                    <br/>
                    <h4>Reportes usuario</h4>
                    <% 
                        if(numReportesUsuario == 0){
                            out.println("<h5>El usuario no ha recibido ningún reporte</h5>");
                        }else{
                            out.println("<h5>Número de reportes: " + numReportesUsuario + "<h5>");
                            out.println(reportesUsuario);
                        }
                    %>
                    <h4>Reportes grupos del usuario</h4>
                    <% 
                        if(numReportesUsuario == 0){
                            out.println("<h5>los grupos de este usuario no han recibido reportes</h5>");
                        }else{
                            out.println("<h5>Número de reportes: " + numReportesGrupo + "<h5>");
                            out.println(reportesGrupo);
                        }
                    %>
                    <h4>Reportes contenidos de los grupos del usuario</h4>
                    <% 
                        if(numReportesUsuario == 0){
                            out.println("<h5>Los contenidos generados por los grupos del usuario no tienen reportes</h5>");
                        }else{
                            out.println("<h5>Número de reportes: " + numReportesContenido + "<h5>");
                            out.println(reportesContenido);
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
