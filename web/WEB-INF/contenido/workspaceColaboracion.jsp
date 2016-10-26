<%@page import="modelo.pojo.Usuario"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="org.apache.tomcat.util.codec.binary.StringUtils"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="model.mdo.DropboxPersistence"%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    Usuario user = (Usuario) session.getAttribute("usuario");
    String destPath = ServletActionContext.getServletContext().getRealPath("/") + "images\\";
    File file = new File(destPath + user.getAvatar());
    // Reading a Image file from file system
    FileInputStream imageInFile = new FileInputStream(file);
    byte imageData[] = new byte[(int) file.length()];
    imageInFile.read(imageData);

    // Converting Image byte array into Base64 String
    StringBuilder sb = new StringBuilder();
    sb.append("data:image/png;base64,");
    sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(imageData, false)));
    String imageDataString = sb.toString();

    imageInFile.close();

    // Obteniendo el archivo JSON de Dropbox.
    String token = request.getParameter("token");
    String titulo = request.getParameter("titulo").replace(" ", "");
    String idEtapa = request.getParameter("idEtapa");
    String version = request.getParameter("version");
    String ruta = String.format("/%s/%s/%s/%s", token, titulo, idEtapa, version);
    String json = new DropboxPersistence().descargarJson(ruta);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Fábricas MDO</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dragula.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/timeline.css">
        <link href="${pageContext.request.contextPath}/css/workspace.css" rel="stylesheet" type="text/css"/>
        <script>
            closeTogetherJS();
            cargando();

            var APP_BASE = "${pageContext.request.contextPath}";
            var ETAPA = "<%=request.getParameter("etapa")%>";
            var ARTEFACTOS = JSON.parse('<%=json%>');
            var RUTA_PERSISTENCIA = '<%=ruta%>';

            var TogetherJSConfig_getUserName = function () {
                return "${session.usuario.nombre} ${session.usuario.APaterno}";
                    };
                    var TogetherJSConfig_getUserAvatar = function () {
                        return "<%=imageDataString%>";
                    };
                    var TogetherJSConfig_findRoom = "<%=request.getParameter("idRoom")%>";
                    TogetherJS();

                    TogetherJS.on("ready", function () {
                        finalizar();
                    });

        </script>
        <script src="${pageContext.request.contextPath}/js/collaboration/dragula.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/collaboration/mdo-factories.js"></script>
        <script src="${pageContext.request.contextPath}/js/collaboration/mdo-utilities.js"></script>
        <script src="${pageContext.request.contextPath}/js/collaboration/jquery-resizable.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/collaboration/funciones.js"></script>

        <script>
            initWorkspace();
            $(".panel-left").resizable({
                handleSelector: ".splitter",
                resizeHeight: false
            });
        </script>
    </head>
    <body>
        <div id="header" class="container" align="center">
            <div class="row">
                <h1><%=request.getParameter("titulo")%></h1>
            </div>
        </div>


        <div class="container-fluid">
            <div class="row">
                <div class="panel-container">
                    <%-- Left Panel --%>
                    <div class="panel-left">
                        <div class="col-md-2 col-sm-2 col-xs-4 fixed">
                            <div id="menuMDO" class="panel-group">
                                <div class="panel panel-danger">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#menuMDO" href="#<%=request.getParameter("etapa")%>Panel">
                                                <%=request.getParameter("etapa")%>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="<%=request.getParameter("etapa")%>Panel" class="panel-collapse collapse in">
                                        <div id="<%=request.getParameter("etapa")%>PanelBody" class="panel-body"></div>
                                    </div>
                                </div>
                            </div>
                            <button id="btnGuardar" class="btn btn-primary btn-block">Guardar</button>
                            <br>
                            <button id="btnDescargar" class="btn btn-primary btn-block">Descargar ZIP</button>
                        </div>
                    </div>
                    <div class="splitter"></div>
                    <%-- Rigth Panel --%>
                    <div class="panel-right">
                        <div class="col-md-12 col-sm-12 col-xs-12 scrollit">
                            <div class="container">
                                <ul id="contenidoDidacticoBody" class="timeline">
                                    <li class="year"><%=request.getParameter("etapa")%></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
