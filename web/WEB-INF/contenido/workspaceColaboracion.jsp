<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%
    String identificadorDisqus = "", paginaDisqus = "";
    if(request.getParameter("idContenido") != null){
       identificadorDisqus = "id" + request.getParameter("idContenido");
       paginaDisqus = "pagina" + request.getParameter("idContenido");
    }
    %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Fábricas MDO</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dragula.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/timeline.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilo.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ElementosMDO.css">
        <script>
            var APP_BASE = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/js/together-js-config.js"></script>
        <script src="${pageContext.request.contextPath}/js/togetherjsEDVA/togetherjs-min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dragula.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/mdo-factories.js"></script>
        <script src="${pageContext.request.contextPath}/js/mdo-utilities.js"></script>
        <script src="${pageContext.request.contextPath}/js/funciones.js"></script>
        <script src="${pageContext.request.contextPath}/js/together-js-comChannel.js" type="text/javascript"></script>
        <script>            
            var disqus_config = function () {
                this.page.url = "http://localhost:8084/EDVA/#!<%= paginaDisqus %>";  // Replace PAGE_URL with your page's canonical URL variable
                this.page.identifier = '<%= identificadorDisqus %>'; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
            };

            (function() { // DON'T EDIT BELOW THIS LINE
                var d = document, s = d.createElement('script');
                s.src = '//http-localhost-8084-edva.disqus.com/embed.js';
                s.setAttribute('data-timestamp', +new Date());
                (d.head || d.body).appendChild(s);
            })();
        </script>
        <noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
    </head>
    <body>
        <div id="header" class="container" align="center">
            <div class="row">
                <h1>Fábricas Abstractas de MDO</h1>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 col-sm-2 col-xs-4 fixed">
                    <div id="menuMDO" class="panel-group">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#menuMDO" href="#vivenciaPanel">
                                        Vivencias
                                    </a>
                                </h4>
                            </div>
                            <div id="vivenciaPanel" class="panel-collapse collapse">
                                <div id="vivenciaPanelBody" class="panel-body"></div>
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#menuMDO" href="#conceptualizacionPanel">
                                        Conceptualización
                                    </a>
                                </h4>
                            </div>
                            <div id="conceptualizacionPanel" class="panel-collapse collapse">
                                <div id="conceptualizacionPanelBody" class="panel-body"></div>
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#menuMDO" href="#documentacionPanel">
                                        Documentación
                                    </a>
                                </h4>
                            </div>
                            <div id="documentacionPanel" class="panel-collapse collapse in">
                                <div id="documentacionPanelBody" class="panel-body"></div>
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#menuMDO" href="#aplicacionPanel">
                                        Aplicación
                                    </a>
                                </h4>
                            </div>
                            <div id="aplicacionPanel" class="panel-collapse collapse">
                                <div id="aplicacionPanelBody" class="panel-body"></div>
                            </div>
                        </div>
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#menuMDO" href="#ampliacionPanel">
                                        Ampliación
                                    </a>
                                </h4>
                            </div>
                            <div id="ampliacionPanel" class="panel-collapse collapse">
                                <div id="ampliacionPanelBody" class="panel-body"></div>
                            </div>
                        </div>
                    </div>
                    <button id="btnGuardar" class="btn btn-primary btn-block">Guardar</button>
                    <br>
                    <button id="btnDescargar" class="btn btn-primary btn-block">Descargar ZIP</button>
                </div>
                <br>
                <br>
                <div class="col-md-10 col-sm-10 col-xs-8 scrollit">
                    <div class="container">
                        <ul id="contenidoDidacticoBody" class="timeline">
                            <li class="year">Vivencia</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 100px">
                <div class="col-md-7"></div>
                <div class="col-md-4">
                    <div id="disqus_thread"></div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div> 
    </body>
</html>
