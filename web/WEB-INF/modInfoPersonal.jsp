<%@page import="modelo.pojo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar información personal</title> 
        <script src="${pageContext.request.contextPath}/js/paginas/modInfoPersonal.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">Modificar Información personal</div>
                <div class="panel-body">
                    <form id="modificarfrm" method="POST" class="form-horizontal" action="modUsuario">
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="correo">Correo Electrónico*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@jmail.com" value="${session.usuario.correo}"/>
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="nombre">Nombre(s)*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="nombre" name="nombre" placeholder="Tu(s) nombre(s)" value="${session.usuario.nombre}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="paterno">Apellido Paterno*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="paterno" name="paterno" placeholder="Tu apellido paterno" value="${session.usuario.APaterno}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="materno">Apellido Materno</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="materno" name="materno" placeholder="Tu apellido materno" value="${session.usuario.AMaterno}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="cedula">Cédula</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="cedula" name="cedula" placeholder="Tu cédula profesional" value="${session.usuario.cedula}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="fechaN">Fecha de Nacimiento*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="fechaN" name="fechaN" placeholder="Tu fecha de nacimiento" value="${session.usuario.fechaNacimiento}"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2" id="button-group">
                                <input id="modify_button" type="button" class="btn btn-success" value="Modificar" onclick="habilitarEdicion()">
                                <%
                                    Usuario usuario = (Usuario)session.getAttribute("usuario");
                                    if(usuario.getFacebook() != 1){
                                    %>
                                <input id="pwd_modify_button" type="button" class="btn btn-primary" value="Cambiar Contraseña" onclick="modificarContrasenia()">
                                <%
                                    }
                                    %>
                            </div>
                        </div>     
                    </form>
                </div>
                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger">
                            <s:actionerror />
                    </div>
                </s:if>
            </div>
        </div>
    </body>
</html>
