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
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="correo">Correo Electrónico*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@jmail.com" value="${session.usuario.correo}"/>
                                <i class="glyphicon glyphicon-envelope form-control-feedback"></i>
                            </div>
                            
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="nombre">Nombre(s)*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="nombre" name="nombre" placeholder="Tu(s) nombre(s)" value="${session.usuario.nombre}"/>
                                <i class="glyphicon glyphicon-user form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="paterno">Apellido Paterno*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="paterno" name="paterno" placeholder="Tu apellido paterno" value="${session.usuario.APaterno}"/>
                                <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="materno">Apellido Materno</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="materno" name="materno" placeholder="Tu apellido materno" value="${session.usuario.AMaterno}"/>
                                <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="cedula">Cédula</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="cedula" name="cedula" placeholder="Tu cédula profesional" value="${session.usuario.cedula}"/>
                                <i class="glyphicon glyphicon-briefcase form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="fechaN">Fecha de Nacimiento*</label>
                            <div class="col-md-4">
                                <input disabled type="text" class="form-control" id="fechaN" name="fechaN" placeholder="Tu fecha de nacimiento" value="${session.usuario.fechaNacimiento}"/>
                                <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2" id="button-group">
                                <!--input id="modify_button" type="button" class="btn btn-success" value="Modificar" onclick="habilitarEdicion()">
                                <input id="pwd_modify_button" type="button" class="btn btn-primary" value="Cambiar Contraseña" onclick="modificarContrasenia()"-->
                                <button id="modify_button" type="button" class="btn btn-success" onclick="habilitarEdicion()"><span class="glyphicon glyphicon-pencil"></span>  Modificar</button>
                                <button id="pwd_modify_button" type="button" class="btn btn-primary" onclick="modificarContrasenia()"><span class="glyphicon glyphicon-eye-close"></span>   Cambiar Contraseña</button>
                                <button id="submit_button" type="submit" class="btn btn-success" style="display:none"><span class="glyphicon glyphicon-ok"></span>  Aceptar</button>
                                <button id="cancel_button" type="button" class="btn btn-danger" style="display:none" onclick="cancelOperation()"><span class="glyphicon glyphicon-repeat"></span>  Cancelar</button>
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
