<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.dao.ConexionDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=X-UA-Compatible content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <style>
            div.contenedor{
                position: relative;
                width: 100%;
                height: inherit;
                border: 3px solid #8AC007;
            }
            div.menu1{
                position: absolute;
                width: 20%;
                height: 40%;
                top:0%;
                border: groove #4e4e4e; 
                border-width: 4px;;
            }
            div.menu2{
                position: absolute;
                width: 20%;
                height: 20%;
                top: 42%;
            }
            div.contenido{
                position: absolute;
                width: 75%;
                height: 100%;
                border: 3px solid #003eff;
                left: 25%;
                top:0%;
            }
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
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css"/>
        <title>Página Principal</title>
    </head>
    <body role="document">
        <%@include file="header.jsp" %>
        <div class="embed-responsive embed-responsive-16by9" id="contenido">
            <div class="menu1">
            </div>
            <div class="menu2">
                <h4>Solicitudes de entrada</h4>
                <br/>
                <div id="text-carousel" class="carousel slide" data-ride="carousel" data-interval="10000" style="width: 100%; height:100%;">
                    <!-- Wrapper for slides -->
                    <div class="row">
                        <div class="col-xs-offset-3 col-xs-6">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <div class="carousel-content">
                                        <div>
                                            <p class="text-carousel">Sapiente, ducimus</p>
                                          <a href='www.facebook.com'>Face</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="carousel-content">
                                        <div>
                                            <p>Víctor el grande </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="carousel-content">
                                        <div>                          
                                            <p>Mola</p>
                                        </div>
                                    </div>
                                </div>
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
        <div id="contenidos_invisibles" style="display: none"></div>
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery/carousel.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>    
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/paginas/funciones.js"></script>
</html>
