<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
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
        <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/croppie.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/avatar.css" rel="stylesheet" type="text/css"/>
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
    </head>
    <body>
        <!-- page-head -->
        <div class="page-head">
            <div class="header-nav ">
                <div class="logo wow fadeInUp animated" data-wow-delay=".5s">
                    <h1>
                        <a class="link link--kumya" href="cwescom"><i></i><span data-letters="CWEScom">CWEScom</span></a>
                    </h1>
                </div>
                <div class="top-nav wow fadeInUp animated" data-wow-delay=".5s">										 
                    <label class="mobile_menu" for="mobile_menu"><span>Menú</span></label>
                        <input id="mobile_menu" type="checkbox">
                        <ul class="nav">
                            <li><a href="cwescom">Inicio</a></li>
                            <li><a href="about">¿Qué es CWEScom?</a></li>
                            <li><a href="#loginModal" data-toggle="modal" data-target="">Inicia Sesión</a></li>
                        </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //page-head -->
        <div class="contact">
            <div class="row">
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                        <s:actionerror />
                    </div>
                </s:if>
                <h3 class="tittle">Regístrate</h3>
                <div class="col-md-12">
                    <div class="col-md-offset-4">
                        <form id="registrarsefrm" method="POST" class="form-horizontal" action="registrarse">
                            <div class="form-group has-feedback">
                                <div class="col-md-6 text-center">
                                    <div class="avatar-layout">
                                        <div class="avatar"> 
                                            <img src="${pageContext.request.contextPath}/images/default-avatar.png" width="300" class="img-circle" id="crop_avatar" onclick="fileChooser();" />
                                            <input id="defaultImage" style="display:none" class="delete" type="image" src="${pageContext.request.contextPath}/images/red-cross.png" width="32" onclick="defaultImage();return false;"/>
                                        </div>
                                    </div>
                                    <input type="hidden" id="avatarImage" name="avatarImageURL"/>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="nombre">Nombre(s)<span class="obligatorio"> *</span></label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Tu(s) nombre(s)"/>
                                    <i class="glyphicon glyphicon-user form-control-feedback"></i>
                                </div>
                            </div>

                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="paterno">Apellido Paterno<span class="obligatorio"> *</span></label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="paterno" name="paterno" placeholder="Tu apellido paterno"/>
                                    <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="materno">Apellido Materno</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="materno" name="materno" placeholder="Tu apellido materno"/>
                                    <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="cedula">Cédula</label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Tu cédula profesional"/>
                                    <i class="glyphicon glyphicon-briefcase form-control-feedback"></i>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="fechaN">Fecha de Nacimiento<span class="obligatorio"> *</span></label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="fechaN" name="fechaN" placeholder="Tu fecha de nacimiento"/>
                                    <!--i class="glyphicon glyphicon-calendar form-control-feedback"></i-->
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="correo">Correo Electrónico<span class="obligatorio"> *</span></label>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@example.com"/>
                                    <i class="glyphicon glyphicon-envelope form-control-feedback"></i>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="password">Contraseña<span class="obligatorio"> *</span></label>
                                <div class="col-md-4">
                                    <input type="password" class="form-control" id="password" name="password"/>
                                    <i class="glyphicon glyphicon-eye-close form-control-feedback"></i>
                                </div>
                            </div>              
                            <div class="form-group has-feedback">
                                <label class="col-md-2 control-label" for="pwd">Repita su contraseña</label>
                                <div class="col-md-4">
                                    <input type="password" class="form-control" id="pwd" name="pwd"/>
                                    <i class="glyphicon glyphicon-eye-close form-control-feedback"></i>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6 col-md-offset-2">
                                    <!--input type="submit" class="btn btn-success" value="Registrarse"/-->
                                    <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span>  Registrarse</button>
                                    <button type="reset" class="btn btn-toolbar" value="Limpiar"><span class="glyphicon glyphicon-erase"></span>  Limpiar</button>
                                    <a href="#loginModal" data-toggle="modal" class="btn btn-link">¿Ya tienes una cuenta? Inicia sesión aquí</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <input onchange="avatarUpload();" type="file" id="imageUpload" accept="image/*" style="display: none;"/> 
                    
            </div>
        </div>
        <!--footer-->
        <%@include file="footer.jsp"%>
        <!-- //footer-->
        <!-- smooth scrolling -->
        <script type="text/javascript">
            $(document).ready(function() {
            /*
                var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear' 
                };
            */								
            $().UItoTop({ easingType: 'easeOutQuart' });
            });
        </script>
        <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <!-- //smooth scrolling -->
        <!-- for bootstrap working -->
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script> 
        <script src="${pageContext.request.contextPath}/js/jquery/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/locale_es.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-datetimepicker.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/croppie.min.js"></script>      
        <script src="${pageContext.request.contextPath}/js/paginas/registrar.js"></script>
        <!-- //for bootstrap working -->
        <!--Modal para el login -->
        <%@include file="login.jsp"%>
        <script src="${pageContext.request.contextPath}/js/paginas/login.js"></script>
    </body> 
</html>
