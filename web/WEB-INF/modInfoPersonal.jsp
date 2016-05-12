<%-- 
    Document   : modInfoPersonal
    Created on : 09-feb-2016, 18:41:09
    Author     : axelcampos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar información personal</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js" type="text/javascript"></script>
        
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-dialog.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css"/>
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
                                <input id="pwd_modify_button" type="button" class="btn btn-primary" value="Cambiar Contraseña" onclick="modificarContrasenia()">
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


<script>
function habilitarEdicion() {
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = false;
    }
    
    var modify_button = document.getElementById("modify_button");
    var pwd_modify_button = document.getElementById("pwd_modify_button");
    
    //Incorporar el boton de submit
    var submit_button = document.createElement("input");
    submit_button.id = "submit_button";
    submit_button.type = "submit";
    submit_button.value = "Aceptar";
    submit_button.action = "modUsuario";
    submit_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(submit_button,modify_button);
    
    //Incorporar el boton de cancelar
    var cancel_button = document.createElement("input");
    cancel_button.id = "cancel_button";
    cancel_button.type = "button";
    cancel_button.onclick = cancelOperation;
    cancel_button.value = "Cancelar";
    cancel_button.className = "btn btn-danger";
    document.getElementById("button-group").replaceChild(cancel_button, pwd_modify_button);
    
}

function cancelOperation()
{   
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = true;
    }
    
    var submit_button = document.getElementById("submit_button");
    var cancel_button = document.getElementById("cancel_button");
       
    var modify_button = document.createElement("input");
    modify_button.id = "modify_button";
    modify_button.onclick = habilitarEdicion;
    modify_button.type = "button";
    modify_button.action = "modUsuario";
    modify_button.value = "Modificar";
    modify_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(modify_button, submit_button);   
    
    var pwd_modify_button = document.createElement("input");
    pwd_modify_button.id = "pwd_modify_button";
    pwd_modify_button.onclick = modificarContrasenia;
    pwd_modify_button.type = "button";
    pwd_modify_button.value = "Cambiar Contraseña";
    pwd_modify_button.className = "btn btn-primary";
    document.getElementById("button-group").replaceChild(pwd_modify_button, cancel_button);
    
    document.getElementById("modificarfrm").reset();
      
}
function modificarContrasenia()
{
    BootstrapDialog.show({
    title: 'Modificar contraseña',
    message: '<form role="form" id="mod_pwd_frm" method="POST" class="form-group" action="modPwd"> <div class="form-group"> <label for="recipient-name" class="control-label">Contraseña actual</label>                       <input type="password" class="form-control" id="old_pwd">                                                            <label for="recipient-name" class="control-label">Contraseña nueva</label>                      <input type="password" class="form-control" id="old_pwd">                                                                <label for="recipient-name" class="control-label">Repetir su Contraseña</label>                        <input type="password" class="form-control" id="old_pwd">                    </div>                  </form>',
    buttons: [{
        id: 'btn-ok',         
        label: 'Aceptar',
        cssClass: 'btn-primary', 
        autospin: false,
        action: function(dialogRef){    
            dialogRef.close();
                }
            }]
    });
}
</script>
