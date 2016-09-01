<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv=X-UA-Compatible content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/datepicker.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/croppie.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/avatar.css" rel="stylesheet" type="text/css"/>
        <title>Registrarse</title>
    </head>
    <body>
        <h1>EDVA CWEScom</h1>
        <br>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">Regístrate</div>
                <div class="panel-body">
                    <s:if test="hasActionErrors()">
                        <div class="alert alert-danger">
                            <s:actionerror />
                        </div>
                    </s:if>
                    <form id="registrarsefrm" method="POST" class="form-horizontal" action="registrarse">
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="avatarImageDataURL">Avatar</label>
                            <div class="col-md-4 text-center">
                                <div class="avatar-layout">
                                    <div class="avatar"> 
                                        <img src="${pageContext.request.contextPath}/images/default-avatar.png" width="300" class="img-circle" id="crop_avatar" onclick="fileChooser();" />
                                        <input id="defaultImage" style="display:none" class="delete" type="image" src="${pageContext.request.contextPath}/images/red-cross.png" width="32" onclick="defaultImage();return false;"/>
                                    </div>
                                </div>
                                <input type="hidden" id="avatarImage" name="avatarImageURL"/>
                            </div>
                        </div>

                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="nombre">Nombre(s)*</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Tu(s) nombre(s)"/>
                                <i class="glyphicon glyphicon-user form-control-feedback"></i>
                            </div>
                        </div>

                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="paterno">Apellido Paterno*</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="paterno" name="paterno" placeholder="Tu apellido paterno"/>
                                <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="materno">Apellido Materno</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="materno" name="materno" placeholder="Tu apellido materno"/>
                                <i class="glyphicon glyphicon-info-sign form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="cedula">Cédula</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Tu cédula profesional"/>
                                <i class="glyphicon glyphicon-briefcase form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="fechaN">Fecha de Nacimiento*</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="fechaN" name="fechaN" placeholder="Tu fecha de nacimiento"/>
                                <i class="glyphicon glyphicon-calendar form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="correo">Correo Electrónico*</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@example.com"/>
                                <i class="glyphicon glyphicon-envelope form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="password">Contraseña*</label>
                            <div class="col-md-4">
                                <input type="password" class="form-control" id="password" name="password"/>
                                <i class="glyphicon glyphicon-eye-close form-control-feedback"></i>
                            </div>
                        </div>              
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="pwd">Repita su contraseña</label>
                            <div class="col-md-4">
                                <input type="password" class="form-control" id="pwd" name="pwd"/>
                                <i class="glyphicon glyphicon-eye-close form-control-feedback"></i>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2">
                                <!--input type="submit" class="btn btn-success" value="Registrarse"/-->
                                <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span>  Registrarse</button>
                                <button type="reset" class="btn btn-toolbar" value="Limpiar"><span class="glyphicon glyphicon-erase"></span>  Limpiar</button>
                                <a href="loginform" class="btn btn-link">¿Ya tienes una cuenta? Inicia sesión aquí</a>
                            </div>
                        </div>
                    </form>
                    <input onchange="avatarUpload();" type="file" id="imageUpload" accept="image/*" style="display: none;"/> 
                </div>

            </div>
            <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-datepicker.js"></script>     
            <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script> 
            <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/js/jquery/croppie.min.js"></script>      
            <script src="${pageContext.request.contextPath}/js/paginas/registrar.js"></script>
        </div>
        <br>
    </body> 
</html>
