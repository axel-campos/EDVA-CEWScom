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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <%-- CSS resources  --%>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/miSidebar.css" type="text/css">
        <link href="${pageContext.request.contextPath}/css/cargando.css" rel="stylesheet" type="text/css"/>

        <%-- JS resources  --%>
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/carousel.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>   
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-table.min.js"></script> 
        <script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-config.js"></script>
        <script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-comChannel.js" type="text/javascript"></script>

        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/locale_es.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-datetimepicker.min.js"></script> 
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-notify.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/paginas/funciones.js"></script>

        <title>Página Principal</title>
        <style>
            @media (max-height: 500px){}
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="spinner" id="cargando" style="display: none;">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
        <div class="alert alert-danger" id="errorPrincipal"  style="display: none;">
            <strong>Atención!</strong> Hubo un error al procesar la solicitud, inténtelo de nuevo
        </div>
        <div class="container-fluid" id="contenido">
            <%@include file="principal.jsp"%>
        </div>
        <div id="contenidos_invisibles" style="display: none"></div>
    </body>
    <script>
        $(document).ready(function () {
            var top1 = $("#header").outerHeight(),
                    top2 = $("#progressBar").outerHeight(),
                    top3 = top1 + top2 + 5;
            $("#progressBar").offset({top: top1});
            $("#contenido").offset({top: top3});
            closeTogetherJS();
        });

        window.onbeforeunload = function () {
            closeTogetherJS();
        };
    </script>
</html>
