/* global pageContext */

$(document).ready(function(){
    $('#loginfrm').bootstrapValidator({
        // message: 'Este valor no es permitido',
        fields: {
            correo: {
                //message: ''
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su correo electrónico'
                    },
                    emailAddress: {
                        message: 'El formato del correo no es correcto'
                    }
                }
            },
            password: {
                validators:{
                    notEmpty: {
                        message: 'Por favor, ingrese su contraseña'
                    }
                }
            }
        }
    });
}); 

function habilitarEdicion() {
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = false;
    }
    //Escondemos los primeros botones
    $("#modify_button").hide();
    $("#pwd_modify_button").hide();
    //Mostramos los segundos botones
    $("#submit_button").show();
    $("#cancel_button").show();
    
    /*var modify_button = document.getElementById("modify_button");
    var pwd_modify_button = document.getElementById("pwd_modify_button");*/
    
    //Incorporar el boton de submit
    /*var submit_button = document.createElement("input");
    submit_button.id = "submit_button";
    submit_button.type = "button";
    submit_button.value = "Aceptar";
    //submit_button.action = "modUsuario";
    submit_button.onclick = modUsuarioCambiarContenido;
    submit_button.className = "btn btn-success";
    document.getElementById("button-group").replaceChild(submit_button,modify_button);*/
    
    //Incorporar el boton de cancelar
    /*var cancel_button = document.createElement("input");
    cancel_button.id = "cancel_button";
    cancel_button.type = "button";
    cancel_button.onclick = cancelOperation;
    cancel_button.value = "Cancelar";
    cancel_button.className = "btn btn-danger";
    document.getElementById("button-group").replaceChild(cancel_button, pwd_modify_button);*/
    
}

function cancelOperation()
{   
    var inputs_forms_nodeList = document.getElementsByClassName("form-control");
    for (i = 0; i < inputs_forms_nodeList.length; i++) 
    {
        inputs_forms_nodeList[i].disabled = true;
    }
    
    // Mostramos los primeros botones
    $("#modify_button").show();
    $("#pwd_modify_button").show();
    //Escondemos los segundos botones
    $("#submit_button").hide();
    $("#cancel_button").hide();
    
    /*var submit_button = document.getElementById("submit_button");
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
    document.getElementById("button-group").replaceChild(pwd_modify_button, cancel_button);*/
    
    document.getElementById("modificarfrm").reset();
      
}
function modificarContrasenia()
{
    BootstrapDialog.show({
        title: 'Modificar contraseña',
        message: function (dialog) {
            var $message = $('<div></div>');
            var pageToLoad = dialog.getData('pageToLoad');
            $message.load(pageToLoad);
            return $message;
        },
        data: {
            'pageToLoad': 'passwdForm'
        },
        buttons: [
            {
                id: 'btn-ok',
                label: 'Aceptar',
                cssClass: 'btn-primary',
                autospin: true,
                action: function (dialogRef) {
                    var form = "#mod_pwd_frm";
                    var action = "modPwd";

                    var datos = $(form).serialize();
                    $.ajax({
                        type: "POST",
                        url: action,
                        data: datos,
                        success: function (data) {
                            $("#contenido").html(data);
                        }
                    });  
                    
                    dialogRef.close();
                    
                }
            },
            {
                id: 'btn-close',
                label: 'Cerrar',
                cssClass: 'btn-danger',
                autospin: false,
                action: function (dialogRef) {
                    dialogRef.close();
                }
            }
        ]
    });
}

function modUsuarioCambiarContenido()
{   
    var form = "#modificarfrm";
    var action = "modUsuario";
    
    var datos = $(form).serialize();
    $.ajax({
        type: "POST",
        url: action,
        data: datos,
        success: function (data) {
            $("#contenido").html(data);
        }
    });   
}
