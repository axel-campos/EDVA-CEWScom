<%@page import="modelo.pojo.Contenido"%>
<%@page import="modelo.dao.ContenidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String token = request.getParameter("token");
    String tipo = "Guardar";
    String id = "";
    String titulo = "", tema = "", descripcion = "", competencia = "";
    if(request.getParameter("id") != null){
        id = request.getParameter("id").toString();
        tipo = "Modificar";
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        contenidoDAO.conectar();
        Contenido contenido = contenidoDAO.buscar(new Contenido().setIdContenido(Integer.parseInt(id)));
        contenidoDAO.desconectar();
        titulo = contenido.getTitulo();
        tema = contenido.getTema();
        descripcion = contenido.getDescripcion();
        competencia = contenido.getCompetencia();
    }
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
                    Ingrese los datos para el contenido didáctico
                    <form id="altaContenido" name="altaContenido" class="form-horizontal">
                        <div class="form-group has-feedback">
                            <label for="titulo" class="col-md-4 control-label">Titulo: <span class="obligatorio"> *</span></label>
                            <div class="col-md-6">
                                <input type="text" id="titulo" name="titulo" class="form-control" value="<%= titulo%>"/>
                                <i class="glyphicon glyphicon-list-alt form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="tema" class="col-md-4 control-label">Tema:</label>
                            <div class="col-md-6">
                                <input type="text" id="tema" name="tema" class="form-control" value="<%= tema%>"/>
                                <i class="glyphicon glyphicon-book form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="descripcion" class="col-md-4 control-label">Descripción</label>
                            <div class="col-md-6">
                                <textarea id="descripcion" class="form-control" rows="5" name="descripcion" style="resize: none;"><%= descripcion%></textarea>
                                <i class="glyphicon glyphicon-comment form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="competencia" class="col-md-4 control-label">Competencia a obtener</label>
                            <div class="col-md-6">
                                <textarea id="competencia" class="form-control" rows="5" name="competencia" style="resize: none;"><%= competencia%></textarea>
                                <i class="glyphicon glyphicon-refresh form-control-feedback"></i>
                            </div>
                        </div> 
                        <input type="hidden" id="token" name="token" value="<%= token%>"/>
                        <input type="hidden" id="tipo" name="tipo" value="<%= tipo%>"/>
                        <input type="hidden" id="id" name="id" value="<%= id%>"/>
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
