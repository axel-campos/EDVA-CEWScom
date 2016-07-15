<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.dao.ConexionDAO"%>
<%@page import="modelo.dao.UsuarioGrupoDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=X-UA-Compatible content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/datepicker.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/jquery.progresstimer.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/carousel.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>    
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-table.min.js"></script>    
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/jquery.progresstimer.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/paginas/funciones.js"></script>
        <title>Página Principal</title>
        <style>
            @media (max-height: 500px){}
        </style>
    </head>
    <body role="document">
        <%@include file="header.jsp" %>
        <div class="loading-progress-2" id="progressBar" style="display: none;"></div>
        <!--div class="embed-responsive embed-responsive-16by9" id="contenido" style="min-height: 500px"-->
        <div id="contenido" class="container-fluid">
            <%@include file="principal.jsp"%>
        </div>
        <div id="contenidos_invisibles" style="display: none"></div>
    </body>
</html>
