<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.dao.ConexionDAO"%>
<%@page import="modelo.dao.UsuarioGrupoDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CWEScom :: EDVA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta property="og:title" content="Vide" />
        <meta name="keywords" content="CWESCOM, EDVA, ESCOM, TT, TT1, TT2, Web Application, Educación, Primaria, Modelo Didáctico Operativo, MDO, Colaborativo" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/principal/CWEScom.ico">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom theme files-->
        <link href="${pageContext.request.contextPath}/css/principal/nav.css" rel="stylesheet" type="text/css" media="all"/>
        <link href="${pageContext.request.contextPath}/css/principal/style.css" rel='stylesheet' type='text/css' />
        <link href="${pageContext.request.contextPath}/css/principal/hover_pack.css" rel='stylesheet' type='text/css' />
        <%-- Para funcionalidad de CWEScom --%>
        <link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">        
        <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css"/>
        <!--link href="{pageContext.request.contextPath}/css/miSidebar.css" rel="stylesheet" type="text/css"-->
        <link href="${pageContext.request.contextPath}/css/ekko-lightbox.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/css/cargando.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/paginas/breadcrumbBarra.css" rel="stylesheet" type="text/css"/>
        
        <!-- JS -->
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
        <!--webfont-->
        <link href='//fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/principal/move-top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/principal/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($) {
                $(".scroll").click(function(event){		
                    event.preventDefault();
                    $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
                });
            });
        </script>
        <!-- start-smoth-scrolling -->
        <!--animate-->
        <link href="${pageContext.request.contextPath}/css/principal/animate.css" rel="stylesheet" type="text/css" media="all">
        <script src="${pageContext.request.contextPath}/js/principal/wow.min.js"></script>
            <script>
                 new WOW().init();
            </script>
        <!--//end-animate-->
		<%-- JS resources  --%>
		<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/carousel.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap/ekko-lightbox.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-table.min.js"></script> 
		<script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-config.js"></script>
		<script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/tjsCWEScom/togetherjs-comChannel.js" type="text/javascript"></script>

		<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/locale_es.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-datetimepicker.min.js"></script> 
		<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/paginas/funciones.js"></script>
		<script>
			$(document).ready(function () {
				closeTogetherJS();
			});

			window.onbeforeunload = function () {
				closeTogetherJS();
			};
		</script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <ul class="barraNavegacion" id="navegacion">
            <li><a href="#">CWEScom</a></li>
			<li><a href="#">Inicio</a></li>
		</ul>
        <div class="spinner" id="cargando" style="display: none;">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
        <div class="alert alert-danger" id="errorPrincipal"  style="display: none;">
            <strong>Atención!</strong> Hubo un error al procesar la solicitud, inténtelo de nuevo
        </div>
        <div class="contact" id="contenido">
            <%@include file="principal.jsp"%>
        </div>
        <div id="contenidos_invisibles" style="display: none"></div>
    </body>
</html>
