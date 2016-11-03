<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- for-mobile-apps -->
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
                            <li><a class="active" href="about">¿Qué es CWEScom?</a></li>
                            <li><a href="#loginModal" data-toggle="modal" data-target="">Inicia Sesión</a></li>
                        </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //page-head -->
        <!-- about -->
        <div class="about-page">
            <div class="container">
                <h3 class="tittle">¿Qué es CWEScom?</h3>
                <div class="about-grids">
                    <div class="col-md-6 about-grid wow fadeInRight animated" data-wow-delay=".5s">
                        <img src="${pageContext.request.contextPath}/images/principal/profesor1.jpg" alt=" " class="img-responsive" />
                    </div>
                    <div class="col-md-6 about-grid wow fadeInLeft animated" data-wow-delay=".5s">
                        <h4>Descripción</h4>
                        <div class="about-gd">
                            <p>
                                <b>CWEScom</b> es una Aplicación Web que ayuda a los profesores de educación primaria a preparar las
                                clases de todas las materias bajo un mismo contenido didáctico de manera colaborativa con otros profesores utilizando
                                como método pedagógico de aprendizaje el <i>Modelo Didáctico Operativo</i>, el cuál propone cinco etapas
                                secuenciales para la enseñanza de un nuevo tema.
                            </p>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- history -->
        <div class="history">
            <div class="container">
                <h3 class="title">¿Qué puedes hacer en <b>CWEScom</b>?</h3>
                <div class="col-md-6 history-left">	
                    <div class="history-left-grid wow fadeInUp animated" data-wow-delay=".5s">
                        <h4>Trabajo colaborativo</h4>
                        <p class="aut">Crea un grupo e invita a otros profesores para que se unan a éste y trabajen en un mismo
                            contenido didáctico <b>al mismo tiempo</b></p>
                    </div>
                    <div class="history-left-grid wow fadeInUp animated" data-wow-delay=".5s">
                        <h4>Administra los tiempos para crear tu contenido didáctico</h4>
                        <p class="aut">Establece la fecha límite para trabajar en una etapa del contenido didáctico. ¿La fecha que 
                            estableciste se acerca y no han terminado la etapa? ¡No te preocupes! Puedes ampliar el periodo establecido 
                            y seguir trabajando en la etapa.</p>
                    </div>
                    <div class="history-left-grid wow fadeInUp animated" data-wow-delay=".5s">
                        <h4>Manejo de versiones</h4>
                        <p class="aut">Puedes crear varias versiones de una misma etapa. Al final, habrá una votación entre éstas para 
                        formar el contenido didáctico.</p>
                    </div>
                </div>
                <div class="col-md-6 history-right wow fadeInRight animated" data-wow-delay=".5s">

                    <h4>Modelo Didáctico Operativo</h4>
                    <p>El Modelo Didáctico Operativo es un metodología de aprendizaje inspirado en el estructuralismo y el constructivismo del 
                        conocimiento según la teoría de Jean Piaget, el cuál consta de cinco etapas secuenciales, es decir, que no se puede avanzar
                        si los objetivos educacionales no se han alcanzado. Las cinco etapas son:
                    </p>
                    <ul>
                        <li><a href="#" data-toggle="modal" data-target="#etapa1"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><b>Vivencias</b></a></li>
                        <li><a href="#" data-toggle="modal" data-target="#etapa2"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><b>Conceptualización</b></a></li>
                        <li><a href="#" data-toggle="modal" data-target="#etapa3"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><b>Documentación</b></a></li>
                        <li><a href="#" data-toggle="modal" data-target="#etapa4"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><b>Ampliación</b></a></li>
                        <li><a href="#" data-toggle="modal" data-target="#etapa5"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><b>Aplicación</b></a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //history -->
        <!-- //about -->
        <!--footer-->
        <%@include file="footer.jsp"%>
        <!-- //footer-->
        <!--Modals-->
        <div class="modal fade" id="etapa1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2>Vivencias</h2>
                    </div>
                    <div class="modal-body modal-spa">
                        <p>
                            Las experiencias vivenciales hacen referencia a los intentos por diseñar y desarrollar el proceso de 
                            formación a partir del enfrentamiento con situaciones reales y situaciones simuladas en relación con 
                            el tema u objeto de conocimiento.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="etapa2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2>Conceptualización</h2>
                    </div>
                    <div class="modal-body modal-spa">
                        <p>
                            Con las conceptualizaciones sobre las vivencias previamente tenidas, se busca intencionalmente crear un
                            espacio obligado para la toma de conciencia de los marcos de referencia 
                            que la persona está utilizando para explicarse el funcionamiento de la realidad manejada.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="etapa3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2>Documentación</h2>
                    </div>
                    <div class="modal-body modal-spa">
                        <p>
                            En la etapa de la documentación se busca confrontar a los estudiantes con las explicaciones, teorías y
                            modelos ya elaborados por la Ciencia, el Arte, la Tecnología o el conocimiento universal.
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="etapa4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2>Ampliación</h2>
                    </div>
                    <div class="modal-body modal-spa">
                        <p>
                            Durante la etapa de la ampliación se profundiza en la documentación proporcionada al alumno. Se recupera
                            la información existente en relación con: 
                            
                            <ul>
                                <li>La evolución histórica de las explicaciones proporcionadas sobre el contenido o tema de la enseñanza.</li>
                                <li>La integración del tema visto con otros temas o contenidos curriculares.</li>
                                <li>La presentación de un enfoque actual contrario o por lo menos distinto al utilizado por el docente para las explicaciones.</li>
                            </ul>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="etapa5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2>Aplicación</h2>
                    </div>
                    <div class="modal-body modal-spa">
                        <p>
                           La etapa de la aplicación se reserva en el MDO para que los alumnos utilicen sus conocimientos adquiridos en el desarrollo de 
                           ejercicios y de proyectos.
                        </p>
                    </div>
                </div>
            </div>
        </div>
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
        <!-- //for bootstrap working -->
        <!--Modal para el login -->
        <%@include file="login.jsp"%>
        <script src="${pageContext.request.contextPath}/js/paginas/login.js"></script>
        
        
    
    </body>
</html>
