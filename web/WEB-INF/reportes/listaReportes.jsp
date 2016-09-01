<%-- 
    Document   : listaProfesores
    Created on : 26/07/2016, 07:42:48 PM
    Author     : Víctor
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="modelo.pojo.Reporte"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.ReporteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String token = "";
    String nombre = "";
    int tipo = 0;
    String correo = "";
    String tema = "";
    String titulo = "";
    String s = "";
    String where = "";
    String checked = "checked";
    if(request.getParameter("token") != null && !request.getParameter("token").trim().isEmpty()){
        token = request.getParameter("token");
        where = "WHERE g.token LIKE '" + token + "'";
    }
    if(request.getParameter("nombre") != null && !request.getParameter("nombre").trim().isEmpty()){
        nombre = request.getParameter("nombre");
        where = "WHERE g.nombre LIKE '" + nombre + "'";
    }
    if(request.getParameter("correo") != null && !request.getParameter("correo").trim().isEmpty()){
        correo = request.getParameter("correo");
        where = "WHERE u.correo LIKE '" + correo + "'";
    }
    if(request.getParameter("tema") != null && !request.getParameter("tema").trim().isEmpty()){
        tema = request.getParameter("tema");
        where = "WHERE c.tema LIKE '" + tema + "'";
    }
    if(request.getParameter("titulo") != null && !request.getParameter("titulo").trim().isEmpty()){
        titulo = request.getParameter("titulo");
        where = "WHERE c.titulo LIKE '" + titulo + "'";
    }
    if(request.getParameter("tipo") != null && Integer.parseInt(request.getParameter("tipo")) != 0){
        tipo = Integer.parseInt(request.getParameter("tipo"));
        if(tipo == 1){  //Profesores
            where = "WHERE !ISNULL(correo)";
        }else if(tipo == 2){    //Contenidos
            where = "WHERE !ISNULL(idContenido)";
        }else if(tipo == 3){    //Grupos
            where = "WHERE !ISNULL(token)";
        }
    }
    if(request.getParameter("atendido") == null || request.getParameter("atendido").trim().isEmpty()){
        checked = "";
        if(where.isEmpty()){
            where = "WHERE r.atendido = 0 ";
        }else{
            where += " AND r.atendido = 0";
        }
    }
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/reportes/listaReportes.js"></script>
        <title>Reportes</title>
    </head>
    <body>
        <div id="filtros" class="container-fluid">
        <form id="frmFiltros" name="frmFiltros" class="form-inline">
            <div class="form-group col-md-3">
                <label for="token">Token:</label>
                    <input type="text" id="token" name="token" class="form-control" value="<%=token%>">
            </div>
            <div class="form-group col-md-4">
                <label for="nombre">Nombre del Grupo:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" value="<%=nombre%>">
            </div>
            <div class="form-group col-md-3">
                <label for="tipo">Tipo:</label>
                    <select class="form-control" id="tipo" name="tipo" style="width:80%">
                        <option value="0">Todos los tipos</option>
                        <% if(tipo == 1){s = "selected"; } %>
                        <option value="1" <%=s%>>Profesores</option>
                        <% if(tipo == 2){s = "selected"; } %>
                        <option value="2" <%=s%>>Contenidos</option>
                        <% if(tipo == 3){s = "selected"; } %>
                        <option value="3" <%=s%>>Grupos</option>
                    </select>
            </div>
            <div class="form-group col-md-2">
                <div class="checkbox">
                    <label><input type="checkbox" id="atendido" name="atendido" <%=checked%>>&nbsp;Atendidos</label>
                </div>
            </div>
            <div class="form-group col-md-12">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            <div class="form-group col-md-3">
                <label for="correo">Correo: </label>
                    <input type="text" id="correo" name="correo" class="form-control" value="<%=correo%>">
            </div>
            <div class="form-group col-md-4">
                <label for="titulo">Título contenido: </label>
                    <input type="text" id="titulo" name="titulo" class="form-control" value="<%=titulo%>">
            </div>
            <div class="form-group col-md-4">
                <label for="tema">Tema contenido: </label>
                    <input type="text" id="tema" name="tema" class="form-control" value="<%=tema%>">
            </div>
            <div class="form-group col-md-1">
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>  Buscar</button>
            </div>
        </form>
    </div>
    <br/>
    <!--Page content -->
    <div id="page-content-wrapper">
        <div class="row">
            <div class="col-md-11" id="paginacion"></div>
            <div class="col-md-1"></div>
        </div>
        <div class="container-fluid" id="contenedorReportes">
            <%
                ReporteDAO reporteDAO = new ReporteDAO();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                int i = 0, div = 0;
                Boolean cerrarDiv = false;
                reporteDAO.conectar();
                List<Map<String, Object>> reportes = reporteDAO.consultaGenerica("" +
                    "SELECT r.causa, r.atendido, " +
                    "(CASE WHEN !ISNULL(r.correo) THEN 'Profesor' " +
                                "WHEN !ISNULL(r.token) THEN 'Grupo' " +
                                "ELSE 'Contenido' " +
                    "END) AS tipoReporte," +
                    "(CASE WHEN !ISNULL(r.correo) THEN CONCAT('SearchProfesor.action?correo=',r.correo) " +
                                "WHEN !ISNULL(r.token) THEN CONCAT('SearchGroups.action?token=',r.token) " +
                                "ELSE CONCAT('ListContenido.action?idContenido=',c.idContenido)  " +
                    "END) AS action," +
                    "(CASE WHEN !ISNULL(r.correo) THEN CONCAT_WS(' ','profesor',u.nombre,u.aPaterno,'con correo',r.correo) " +
                                "WHEN !ISNULL(r.token) THEN CONCAT_WS(' ','grupo',g.nombre,' con token',r.token) " +
                                "ELSE CONCAT_WS(' ','contenido',c.titulo,' con tema',c.tema) " +
                    "END) AS reportado, r.fechaReporte, CONCAT_WS(' ',u2.nombre,u2.aPaterno,'con correo',u2.correo) AS reportando " +
                    "FROM reporte r " +
                    "LEFT JOIN contenido  AS c ON c.idContenido = r.idContenido " +
                    "LEFT JOIN usuario AS u ON r.correo = u.correo " +
                    "LEFT JOIN grupo AS g ON g.token = r.token " +
                    "LEFT JOIN usuario AS u2 ON r.correoReportando = u2.correo " + where);
                for(i = 0; i < reportes.size(); i++){
                    Map<String, Object> columna = reportes.get(i);
                    String tipoReporte = (String)columna.get("tipoReporte");
                    String causa = (String)columna.get("causa");
                    String reportado = (String)columna.get("reportado");
                    String id = (String)columna.get("id");
                    String fecha = df.format((Timestamp)columna.get("fechaReporte"));
                    String reportando = (String)columna.get("reportando");
                    String action = (String)columna.get("action");
                    int atendido = (int)columna.get("atendido");
                    if(i % 8 == 0){
                        div++;
                        out.println("<div id='div_" + div + "' name='div_" + div + "'>");
                        out.println("<div class=\"col-xs-12\">&nbsp;</div>");
                        cerrarDiv = true;
                    }
                    if(i % 2 == 0){
                        out.println("<div class='row'>");
                    }
                    out.println("<div class='col-xs-5'>");
                    if(atendido == 1){
                        out.println("<div class=\"list-group-item list-group-item-danger\">");
                    }else{
                        out.println("<div class=\"list-group-item list-group-item-success\">");
                    }
                %>
                <a onclick="cambiarContenidos('<%=action%>','#contenido')" style='cursor:pointer;' class="list-group-item">
                    <h4 class="list-group-item-heading"><%=tipoReporte%></h4>
                    <p class="list-group-item-text">
                        El <%=reportado%> fue reportado debido a <%=causa%>, el reporte se generó en la fecha <%=fecha%>
                        por el profesor <%=reportando%> <br/>
                    </p>
                </a>
            <%
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<div class='col-xs-1'></div>");
                    if(i % 2 == 1){
                        out.println("</div>");
                    }
                    if(i % 8 == 7){
                        out.println("</div>");
                        cerrarDiv = false;
                    }
                }
                if(cerrarDiv){
                    out.println("</div>");
                }     
                reporteDAO.desconectar();
            %>
        </div>
    </div>
    <input type="hidden" id="numDivs" name="numDivs" value="<%=div%>"/>
    </body>
</html>
