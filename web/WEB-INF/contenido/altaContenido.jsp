<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String token = request.getParameter("token");
    String tipo = "Guardar";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Contenido</title>
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/altaContenido.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form id="altaContenido" name="altaContenido" class="form-horizontal">
                        <div class="form-group has-feedback">
                            <label for="titulo" class="col-md-4 control-label">Titulo*:</label>
                            <div class="col-md-6">
                                <input type="text" id="titulo" name="titulo" class="form-control" value=""/>
                                <i class="glyphicon glyphicon-list-alt form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="tema" class="col-md-4 control-label">Tema:</label>
                            <div class="col-md-6">
                                <input type="text" id="tema" name="tema" class="form-control" value=""/>
                                <i class="glyphicon glyphicon-book form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="descripcion" class="col-md-4 control-label">Descripción</label>
                            <div class="col-md-6">
                                <textarea id="descripcion" class="form-control" rows="5" name="descripcion" style="resize: none;"></textarea>
                                <i class="glyphicon glyphicon-comment form-control-feedback"></i>
                            </div>
                        </div>                                
                        <input type="hidden" id="token" name="token" value="<%= token%>"/>
                        <input type="hidden" id="tipo" name="tipo" value="<%= tipo%>"/>
                    </form>
                </div>
                    <s:if test="hasActionMessages()">
                        <div class="alert alert-success">
                            <s:actionmessage />
                        </div>
                    </s:if>
                    <s:if test="hasActionErrors()">
                        <div class="alert alert-danger">
                            <s:actionerror />
                        </div>
                    </s:if>
            </div>
        </div>
    </body>
</html>
