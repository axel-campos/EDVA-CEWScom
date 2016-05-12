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
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>    
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
        <script>
            function cambiarContenidos(pagina, target){
                var destino = target;
                if(pagina !== "#"){
                    $(destino).load(pagina,function(){
                        $(".button").button();
                    });
                }
            }
        </script>
        <title>Página Principal</title>
    </head>
    <body role="document">
        <%@include file="header.jsp" %>
        <div class="embed-responsive embed-responsive-16by9" id="contenido">
            
        </div>
    </body>
</html>
