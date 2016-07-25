/* global pageContext */
$(document).ready(function () {
    $('#fechaN').datepicker({
        format: "yyyy-mm-dd"
    });
    $('#modificarfrm').bootstrapValidator({
        // message: 'Este valor no es permitido',
        fields: {
            correo: {
                //message: ''
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese un correo'
                    },
                    emailAddress: {
                        message: 'El formato del correo no es correcto'
                    }
                }
            },
            nombre: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su nombre'
                    },
                    regexp: {
                        regexp: /^[A-Za-záéíóúñÁÉÍÓÚÑ]{1,}([\s][A-Za-záéíóúñÁÉÍÓÚÑ]{1,}){0,}$/,
                        message: "Formato incorrecto. Solo puede contener mayúsculas, minúsculas, acentos o la ñ"
                    },
                    stringLength: {
                        max: 20,
                        message: "El campo nombre no puede tener más de 20 caracteres."
                    }
                }
            },
            paterno: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su apellido paterno'
                    },
                    regexp: {
                        regexp: /^[A-Za-záéíóúñÁÉÍÓÚÑ]{1,}$/,
                        message: "Formato incorrecto. Solo puede contener mayúsculas, minúsculas, acentos o la ñ"
                    },
                    stringLength: {
                        max: 20,
                        message: "El campo Apellido Paterno no puede tener más de 20 caracteres."
                    }
                }
            },
            materno: {
                validators: {
                    regexp: {
                        regexp: /^[A-Za-záéíóúñÁÉÍÓÚÑ]{0,}$/,
                        message: "Formato incorrecto. Solo puede contener mayúsculas, minúsculas, acentos o la ñ"
                    },
                    stringLength: {
                        min: 0,
                        max: 20,
                        message: "El campo Apellido Materno no puede tener más de 20 caracteres."
                    }
                }
            },
            cedula: {
                validators: {
                    stringLength: {
                        min: 0,
                        max: 20,
                        message: "El campo cédula no puede tener más de 20 caracteres"
                    }
                }
            },
            fechaN: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su fecha de Nacimiento'
                    },
                    regexp: {
                        regexp: /^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/,
                        message: 'El formato de la fecha (yyyy-[m]m-[d]d) no es correcta'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e){
        //Prevent form submission
        e.preventDefault();
        //Use Ajax to submit form data
        var datos = $(form).serialize();
        $.ajax({
            type: "POST",
            url: action,
            data: datos,
            success: function(data){
                var target = "#contenido";
                $(target).html(data);
            }
        });
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
                            dialogRef.close();
                        }
                    });
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
