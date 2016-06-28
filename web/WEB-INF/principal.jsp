<%@page import="java.util.Arrays"%>
<%@page import="modelo.pojo.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.dao.ConexionDAO"%>
<%@page import="modelo.dao.UsuarioGrupoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .carousel-content {
                color:black;
                display:flex;
                align-items:center;
            }

            #text-carousel {
              width: 100%;
              height: auto;
            }
        </style>
    </head>
    <body>
        <div class="container container-fluid" style="width: 100%;">
            <div class="row-fluid">
                <div class="col-sm-4 well">
                    <div class="well">
                        <h4>Actualizaciones grupos</h4>
                        <ul class="list-group">
                        <%
                            List<String> tipo = Arrays.asList("","Coordinador","Administrador","Colaborador");
                            Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
                            UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
                            usuarioGrupoDAO.conectar();
                            String consulta = "SELECT ugl.*, g.nombre FROM usuariogrupo_log ugl " +
                                               "INNER JOIN grupo AS g ON g.token = ugl.token "+
                                               "WHERE ugl.correo = '" + usuario.getCorreo() + "'LIMIT 10;";
                            List<Map<String, Object>> tabla1 = usuarioGrupoDAO.consultaGenerica(consulta);
                            for(int i = 0; i < tabla1.size(); i++){
                                out.println("<li class='list-group-item' class='clearfix'><p style='font-family: verdana; font-size: 8px'>");
                                Map<String, Object> columna = tabla1.get(i);
                                if(columna.get("aceptado_nuevo") == null){
                                    out.println("Se rechazó tu solicitud al grupo " + columna.get("nombre") + "(" + columna.get("token") + ")");
                                }else if(columna.get("aceptado_anterior") == null){
                                    out.println("Se envió tu solicitud al grupo " + columna.get("nombre") + "(" + columna.get("token") + ")");
                                }else{
                                    if(columna.get("aceptado_anterior") != columna.get("aceptado_nuevo")){
                                        out.println("Se aceptó tu solicitud al grupo " + columna.get("nombre") + "(" + columna.get("token") + ")");
                                    }else{
                                        out.println("Se rol en el grupo " + columna.get("nombre") + "(" + columna.get("token") + ") ha sido cambiado de: ");
                                        out.println("" + tipo.get((int)columna.get("idtipoUsuarioGrupo_anterior")) + " a " + tipo.get((int)columna.get("idtipoUsuarioGrupo_nuevo")));
                                    }
                                }
                                out.println("</p></li>");
                            }

                            if(tabla1.size() == 0){
                                out.println("<li class='list-group-item' class='clearfix'><p style='font-family: verdana; font-size: 10px'>");
                                out.println("Únete a un grupo de trabajo para recibir notificaciones");
                                out.println("</p></li>");
                            }
                            %>
                        </ul>
                    </div>
                    <div class="well">
                        <h4>Solicitudes de entrada</h4>
                        <br/>
                        <div id="text-carousel" class="carousel slide" data-ride="carousel" data-interval="10000" style="width: 100%; height:100%;">
                            <!-- Wrapper for slides -->
                            <div class="row">
                                <div class="col-xs-offset-3 col-xs-6">
                                    <div class="carousel-inner">
                                        <%
                                            String sql = "SELECT ug.correo, CONCAT_WS(' ',u.nombre,u.aPaterno,u.aMaterno) AS NombreCompleto, ug.token, g.nombre " +
                                                "FROM usuariogrupo AS ug " +
                                                "INNER JOIN usuario AS u ON ug.correo = u.correo " +
                                                "INNER JOIN grupo AS g ON ug.token = g.token " +
                                                "WHERE ug.token IN (SELECT ug2.token FROM usuariogrupo AS ug2 WHERE ug2.correo = '"+ usuario.getCorreo() +"'  AND ug2.idtipoUsuarioGrupo = 1) " +
                                                "AND aceptado = 0 AND idtipoUsuarioGrupo = 3;";
                                            List<Map<String, Object>> tabla = usuarioGrupoDAO.consultaGenerica(sql);
                                            int i = 0;
                                            for(i = 0; i < tabla.size(); i++){
                                                Map<String, Object> columna = tabla.get(i);
                                                if(i == 0){
                                                    out.println("<div class='item active' id='item"+ i +"'>");
                                                }else{
                                                    out.println("<div class='item' id='item"+ i +"'>");
                                                }
                                                out.println("<div class='carousel-content'>");
                                                out.println("<div>");
                                                out.println("<p style='font-family: verdana; font-size: 10px'>Hay una solicitud del usuario: <br/> " + columna.get("NombreCompleto") +
                                                            " (" +columna.get("correo")+ ") para el grupo: <br/> " + columna.get("nombre") + " ( " + columna.get("token") + ")</p>");
                                                out.println("<br/><table style='width=100%'><tr>");
                                                out.println("<td style=\"width=40%\" align=\"center\"><input id=\"modify_button\" type=\"button\" class=\"btn btn-success\" value=\"Aceptar\" "
                                                            + "style=\"width: 60px; heigth: 15px; font-size: 9px\" onclick=\"responderSolicitud('"+columna.get("token")+"','"+columna.get("correo")+"','0','" + i + "')\"></td>" +
                                                            "<td style=\"width=20\">&nbsp;&nbsp;</td>" +
                                                            "<td style=\"width=40%\" align=\"center\"><input id=\"pwd_modify_button\" type=\"button\" class=\"btn btn-danger\" value=\"Rechazar\" "
                                                            + "style=\"width: 60px; heigth: 15px; font-size: 9px\" onclick=\"responderSolicitud('"+columna.get("token")+"','"+columna.get("correo")+"','1','" + i + "')\"></td>");
                                                out.println("</tr></table>");
                                                out.println("</div>");
                                                out.println("</div>");
                                                out.println("</div>");
                                            }

                                            if(tabla.size() == 0){
                                                out.println("<div class='item-active'>");
                                                out.println("<div class='carousel-content'>");
                                                out.println("<div>");
                                                out.println("<p style='font-family: verdana; font-size: 11px'>No hay solicitudes que atender en tus grupos</p>");
                                                out.println("</div>");
                                                out.println("</div>");
                                                out.println("</div>");
                                                i = 1;
                                            }
                                            out.println("<input type='hidden' id='noItems' name='noItems' value='" + i +"'>");
                                        %>
                                    </div>
                                </div>
                            </div>
                            <!-- Controls --> 
                            <a class="left carousel-control" href="#text-carousel" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#text-carousel" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Contenido
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/paginas/principal.js"></script>
    </body>
</html>
