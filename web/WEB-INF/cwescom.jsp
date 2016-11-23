<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CWEScom :: EDVA</title>
        <!-- for-mobile-apps -->
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
        <link href="${pageContext.request.contextPath}/css/principal/iconeffects.css" rel='stylesheet' type='text/css' />
        <link href="${pageContext.request.contextPath}/css/principal/style.css" rel='stylesheet' type='text/css' />
        <!-- JS -->
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery/jquery.easydropdown.js"></script>
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
        <!-- accordian -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
            <script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.10.3.custom.js"></script>
              <script>
                  $(function() {
                    $( "#accordion" ).accordion();
                  });
              </script>
        <!-- //accordian -->
        <!-- tabs -->
        <script src="${pageContext.request.contextPath}/js/principal/easyResponsiveTabs.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('#horizontalTab').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion           
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                    });
                });				
            </script>
        <!-- //tabs -->
        <!--animate-->
        <link href="${pageContext.request.contextPath}/css/principal/animate.css" rel="stylesheet" type="text/css" media="all">
        <script src="${pageContext.request.contextPath}/js/principal/wow.min.js"></script>
            <script>
                 new WOW().init();
            </script>
        <!--//end-animate-->
        
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.1.min.js"><\/script>')</script>
        <script src="${pageContext.request.contextPath}/js/principal/jquery.vide.min.js"></script>
    </head>
    <body>
        <div data-vide-bg="${pageContext.request.contextPath}/images/principal/training">
            <div class="center-container">
                <div class="ban-shade">
                    <div class="header-nav">
                        <div class="logo wow fadeInUp animated" data-wow-delay=".5s">
                            <h1>
                                <a class="link link--kumya" href="cwescom"><i></i><span data-letters="CWEScom">CWEScom</span></a>
                            </h1>
                        </div>
                        <div class="top-nav wow fadeInUp animated" data-wow-delay=".5s">										 
                            <label class="mobile_menu" for="mobile_menu"><span>Menú</span></label>
                            <input id="mobile_menu" type="checkbox">
                            <ul class="nav">
                                <li><a class="active" href="cwescom">Inicio</a></li>
                                <li><a href="about">¿Qué es CWEScom?</a></li>
                                <li><a href="#loginModal" data-toggle="modal" data-target="">Inicia Sesión</a></li>
                            </ul>
                         </div>
                        <div class="clearfix"></div>

                    </div>
                    <div class="socials">
                        <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-4dd797b06396480a"></script>
                    </div>
                    <div class="box_1-top">
                        <div class="banner-info wow fadeInLeft animated" data-wow-delay=".5s">
                            <h2>El objetivo de la educación es preparar a los jóvenes a educarse a ellos mismos para el futuro</h2>
                            <h3> - Robert M. Hutchins</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--banner bottom-->
        <div class="about">
            <div class="col-md-6 about-left wow fadeInRight animated" data-wow-delay=".5s">
                <h3>Bienvenido a CWEScom</h3>
                <p>CWEScom es una propuesta desarrollada por alumnos de la Escuela Superior 
                de Cómputo (ESCOM) que facilita a los profesores desarrollar los contenidos
                de las materias que se asignan a nivel primaria, con ayuda de otros profesores</p>
            </div>
            <div class="col-md-6 about-right wow fadeInLeft animated" data-wow-delay=".5s">
                <div class="hi-icon-wrap hi-icon-effect-4 hi-icon-effect-4b">
                    <div class="abt-icon">
                        <a href="#" class="hi-icon icon1"></a>
                        <h4>Trabajo duro</h4>
                    </div>
                    <div class="abt-icon">
                        <a href="#" class="hi-icon icon2"></a>
                        <h4>Conocimiento</h4>
                    </div>
                    <div class="abt-icon">
                        <a href="#" class="hi-icon icon3"></a>
                        <h4>Éxito</h4>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!--//banner bottom-->
        <!--content-->
        <div class="content">
            <div class="container">
                <h3>Contenidos didácticos basados en MDO</h3>
                <div class="col-md-6 content-left wow fadeInLeft animated" data-wow-delay=".5s">
                    <h4>Una alternativa para preparar las clases</h4>
                    <p>En CWEScom usted podrá diseñar un sólo proyecto de manera colaborativa que contenga
                    todos los temas a impartir en las aulas de clase, utilizando como método pedagógico
                    de enseñanza el <b>Modelo Didáctico Operativo</b> (MDO)</p>
                    <a href="about" class="hvr-shutter-in-vertical button">Más información</a>
                </div>
                <div class="col-md-6 content-right wow fadeInRight animated" data-wow-delay=".5s">
                    <div class="con-left text-center">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <h5>Trabajo colaborativo</h5>
                        <p>Usted y un grupo de profesores podrán trabajar en el mismo contenido didáctico.</p>
                    </div>
                    <div class="con-left text-center">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                        <h5>Contenido Didáctico</h5>
                        <p>Es una guía para que usted dirija la clase, haciendo que la formación de los alumnos
                            sea integral.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--//content-->
        
        <!--footer-top-->
        <div id="faculty" class="footer-top wow fadeInLeft animated" data-wow-delay=".5s">
            <div class="container">
                <h3>Conozca a los desarrolladores de esta increísble herramienta</h3>
                <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">

                    <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tabs-para tab-pane fade in active" id="home" aria-labelledby="home-tab">                           
                            <h4>Christian Axel Campos López</h4>
                            <h5><span class="quote1"></span>Sed ut perspiciatis unde omnis iste natus error sit 
                                voluptatem accusantium doloremque
                                laudantium, totam rem aperiam. Sed ut perspiciatis 
                                unde omnis iste natus error sit voluptatem accusantium
                                doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo.<span class="quote2"></span></h5>
                            <div class="clearfix"></div>
                        </div>
                        <div role="tabpanel" class="tabs-para tab-pane fade" id="profile" aria-labelledby="profile-tab">                           
                            <h4>Víctor Hugo Garrido Gutiérrez</h4>
                            <h5><span class="quote1"></span>El conocimiento de una ingeniería en específico o licenciatura
                                no es nada hasta que empieza a interactuar con otras, lo fascinante de las ciencias de la
                                computación es lo fácil y adaptable que puede ser relacionarse con otra área.
                                La educación es la herramienta principal de una sociedad inteligente, nosotros buscamos
                                darle una herramienta a la educación.
                                <span class="quote2"></span></h5>
                            
                            <div class="clearfix"></div>
                        </div>
                        <div role="tabpanel" class="tabs-para tab-pane fade" id="return" aria-labelledby="return-tab">                           
                            <h4>Luis Enrique Hernández Hernández</h4>
                            <h5><span class="quote1"></span>Doloremque ut perspiciatis unde omnis iste natus error sit 
                                voluptatem accusantium doloremque
                                laudantium, totam rem aperiam. Sed ut perspiciatis 
                                unde omnis iste natus error sit voluptatem accusantium
                                doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo.<span class="quote2"></span></h5>
                            <div class="clearfix"></div>
                        </div>
                        <div role="tabpanel" class="tabs-para tab-pane fade" id="team4" aria-labelledby="team4-tab">                           
                            <h4>Daniel Abraham Huerta Velasco</h4>
                            <h5><span class="quote1"></span>Veo en las <b>Tecnologías de la Información y Comunicación</b>
                                una oportunidad magnífica para crear herramientas que simplifiquen la importantísima tarea de educar al futuro de la sociedad: Los niños.
                                <span class="quote2"></span></h5>		
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <ul id="myTab" class="nav nav-tabs text-center" role="tablist">
                        <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true"><img src="${pageContext.request.contextPath}/images/principal/edva1.jpg" alt=" " /></a></li>
                        <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile"><img src="${pageContext.request.contextPath}/images/principal/edva2.jpg" alt=" " /></a></li>
                        <li role="presentation"><a href="#return" role="tab" id="return-tab" data-toggle="tab" aria-controls="return"><img src="${pageContext.request.contextPath}/images/principal/edva3.jpg" alt=" " /></a></li>
                        <li role="presentation"><a href="#team4" role="tab" id="team4-tab" data-toggle="tab" aria-controls="team4"><img src="${pageContext.request.contextPath}/images/principal/edva4.jpg" alt=" " /></a></li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
            </div>
        </div>
        <!--//footer-top-->
        <!--footer-->
        <%@include file="footer.jsp"%>
        <!-- //footer-->
        <!-- smooth scrolling -->
        <script type="text/javascript">
            $(document).ready(function() {							
                $().UItoTop({ easingType: 'easeOutQuart' });
            });
        </script>
        <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <!-- //smooth scrolling -->
        <!-- for bootstrap working -->
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>        
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
        <!-- //for bootstrap working -->
        <!--Modal para el login -->
        <%@include file="login.jsp"%>
        <script src="${pageContext.request.contextPath}/js/paginas/login.js"></script>
        
        <s:if test="hasActionErrors()">
            <div id="msjError" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <div class="modal-body">
                                <p>Su correo y/o contraseña son incorrectas. Por favor, inténtelo de nuevo.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">De acuerdo</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </s:if>
        <script src="${pageContext.request.contextPath}/js/paginas/cwescom.js"></script>
    </body>
</html>
