<%-- 
    Document   : fileManager
    Created on : 14/11/2016, 10:39:34 PM
    Author     : Axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recursos</title> 
        <link href="${pageContext.request.contextPath}/css/fileManager/bootstrap-editable.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/fileManager/demo.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/fileManager/uploader.css" rel="stylesheet" type="text/css"/>
        <script>
            var RUTA = "/<%=request.getParameter("token")%>/<%=request.getParameter("idContenido")%>";
        </script>
    </head>
    <body>
        <div id="alert_placeholder" class="container-fluid">
            <!--Incoming Messages-->
        </div>
        <div class="table-responsive container-fluid" id='div1'>
            <div id="toolbar">
                <button id="remove" type="button" class="btn btn-default">
                    <i class="glyphicon glyphicon-trash"></i>
                </button>
                <button type="button" class="btn btn-default" onclick="dialogFileUploader.open();">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Subir Archivos</span>
                </button>
                <button id="zipMe" type="button" class="btn btn-default">
                    <i class="glyphicon glyphicon-download"></i>
                    <span>Descargar ZIP</span>
                </button>
            </div>
            <table id="tabla"
                   data-toolbar="#toolbar"
                   data-search="true"
                   data-show-refresh="true"
                   data-show-columns="true"
                   data-minimum-count-columns="2"
                   data-pagination="true"
                   data-id-field="name"
                   data-unique-id="name"
                   data-page-list="[10, 25, 50, 100, ALL]"
                   data-show-footer="false"
                   data-url="files/listFiles"
                   data-side-pagination="client"
                   data-cache="false">
            </table>
        </div>
    </body>
    <script src="${pageContext.request.contextPath}/js/fileManager/bootstrap-table-editable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/fileManager/bootstrap-editable.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/fileManager/demo.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/fileManager/dmuploader.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/fileManager/fileManagement.js" type="text/javascript"></script>
</html>
