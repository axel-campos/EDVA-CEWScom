<%-- 
    Document   : listarContenidos
    Created on : 4/10/2016, 08:40:23 PM
    Author     : Víctor
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.ContenidoDAO"%>
<%
    String token = "";
    String titulo = "";
    String tema = "";
    String fechaInicio = "";
    String nombre = "";
    String fechaFin = "";
    String where = " LIMIT 1000";
    
    if(request.getParameter("token") != null && !request.getParameter("token").trim().isEmpty()){
        token = request.getParameter("token");
        where = "AND c.token LIKE '" + token + "'";
    }
    if(request.getParameter("nombre") != null && !request.getParameter("nombre").trim().isEmpty()){
        nombre = request.getParameter("nombre");
        where = "AND g.nombre LIKE '" + nombre + "'";
    }
    if(request.getParameter("titulo") != null && !request.getParameter("titulo").trim().isEmpty()){
        titulo = request.getParameter("titulo");
        where = "AND c.titulo LIKE '" + titulo + "'";
    }
    if(request.getParameter("tema") != null && !request.getParameter("tema").trim().isEmpty()){
        tema = request.getParameter("tema");
        where = "AND c.tema LIKE '" + tema + "'";
    }
    if(request.getParameter("fechaInicio") != null && !request.getParameter("fechaInicio").trim().isEmpty()){
        fechaInicio = request.getParameter("fechaInicio");
        where = "AND ce.tiempoModificacion >= '" + fechaInicio + "'";
    }
    if(request.getParameter("fechaFin") != null && !request.getParameter("fechaFin").trim().isEmpty()){
        fechaFin = request.getParameter("fechaFin");
        where = "AND ce.tiempoModificacion <= '" + fechaFin + "'";
    }
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/listarContenidos.js"></script>
        <link href="${pageContext.request.contextPath}/css/paginas/listarContenidos.css" rel="stylesheet">
        <title>Menú contenidos</title>
    </head>
    <body>
    <div id="filtros" class="container-fluid">
        <form id="frmFiltros" name="frmFiltros" class="form-inline">
            <div class="form-group col-md-3">
                <label for="token">Tema:&nbsp;</label>
                    <input type="text" id="tema" name="tema" class="form-control" value="<%=tema%>">
            </div>
            <div class="form-group col-md-4">
                <label for="nombre">Nombre del grupo:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" value="<%=nombre%>">
            </div>
            <div class="form-group col-md-4">
                <label for="nombre">Título:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="text" id="titulo" name="titulo" class="form-control" value="<%=titulo%>">
            </div>
            <div class="col-md-1"></div>
            <div class="form-group col-md-12">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
            <div class="form-group col-md-3">
                <label for="correo">Token: </label>
                    <input type="text" id="token" name="token" class="form-control" value="<%=token%>">
            </div>
            <div class="form-group col-md-4">
                <label for="titulo">Fecha Inicio: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="text" id="fechaInicio" name="fechaInicio" class="form-control" value="<%=fechaInicio%>">
            </div>
            <div class="form-group col-md-4">
                <label for="tema">Fecha Fin: </label>
                    <input type="text" id="fechaFin" name="fechaFin" class="form-control" value="<%=fechaFin%>">
            </div>
            <div class="form-group col-md-1">
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>  Buscar</button>
            </div>
        </form>
    </div>
    <br/>
    <div id="page-content-wrapper">
    <%
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        contenidoDAO.conectar();
        String sql = "SELECT * FROM contenido c " +
            "INNER JOIN contenidoetapa ce ON c.idContenido = ce.idContenido AND ce.idEtapa = 6 " +
            "INNER JOIN grupo g ON g.token = c.token " +
            "WHERE c.finalizado = 1 " + where;
        List<Map<String, Object>> contenidos = contenidoDAO.consultaGenerica(sql);
        int contador = 0, div = 0;
        Boolean cerrarDiv = false, cerrarRow = false;
        if(contenidos != null && contenidos.size() > 0)
        {
            for(Map<String, Object> contenido: contenidos){
                String idContenido = (Integer)contenido.get("idContenido") + "";
                String tokenContenido = contenido.get("token").toString();
                String tituloContenido = (String)contenido.get("titulo");
                String temaContenido = (String)contenido.get("tema");
                String descripcion = (String)contenido.get("descripcion");
                if(descripcion.length() > 50){
                    descripcion = descripcion.substring(0, 50) + "...";
                }
                if(contador % 20 == 0){
                    div++;
                    out.println("<div id='div_" + div + "' name='div_" + div + "'>");
                    out.println("<div class=\"col-xs-12\">&nbsp;</div>");
                    cerrarDiv = true;
                }
                if(contador % 4 == 0){
                    if(contador != 0){
                        out.println("</div>");
                        cerrarRow = false;
                    }
                    out.println("<div class='row'>");
                    cerrarRow = true;
                }
            %>
            <div class="col-md-3">
                <div class="col-md-2"></div>
                <div class="col-md-10">
                    <a <a style='cursor: pointer' onclick="visualizarContenidoFinalizado('<%=tokenContenido%>','<%=idContenido%>')">
                        <div class="row" id="box-search">
                            <div class="thumbnail text-center">
                                <img src="${pageContext.request.contextPath}/images/marco3.JPG" class="img-responsive">
                                <div class="caption">
                                    <b>Título: </b> <%=tituloContenido%>
                                    <br/><b>Tema: </b> <%=temaContenido%>
                                    <br/><b>Descripcion</b> <%=descripcion%>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <%
                if(contador % 20 == 19){
                    out.println("</div>");  //Cerramos el div de páginación
                    cerrarDiv = false;
                }
                contador++;
            }
            if(cerrarRow){
                out.println("</div>");
            }
            if(cerrarDiv){
                out.println("</div>");
            }
        }else{
            out.println("<h2>No hay contenidos finalizados en el sistema</h2>");
        }
        %>
    </div>
    </body>
</html>
