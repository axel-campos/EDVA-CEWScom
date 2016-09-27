<%-- 
    Document   : crearReporte
    Created on : 20/09/2016, 06:03:55 PM
    Author     : Víctor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int tipoReporte = 0;
    String valor = "";
    if(request.getParameter("tipoReporte") != null){
        tipoReporte = Integer.parseInt((String)request.getParameter("tipoReporte"));
    }
    if(request.getParameter("valor") != null){
        valor = (String)request.getParameter("valor");
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/reportes/crearReporte.js"></script>
        <title>EDVA</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form id="reporte" name="reporte" class="form-horizontal">
                        <div class="form-group has-feedback">
                            <label for="causa" class="col-md-4 control-label">Causa: </label>
                            <div class="col-md-6">
                                <textarea id="causa" class="form-control" rows="5" name="causa" style="resize: none;"></textarea>
                                <i class="glyphicon glyphicon-edit form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-10 col-md-offset-4">
                                <input type="hidden" id="tipoReporte" name="tipoReporte" value="<%=tipoReporte%>">
                                <input type="hidden" id="valor" name="valor" value="<%=valor%>">
                            </div>
                        </div>
                    </form>
                </div>                
            </div>
        </div>
    </body>
</html>
