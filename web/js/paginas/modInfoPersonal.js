/* global pageContext */
$(document).ready(function () {
    $("#fechaN").datetimepicker({
        locale: 'es',
        format: 'YYYY-MM-DD'
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

//Obtaining path and image name for edit.
var rutaFoto = $("#crop_avatar").attr("src");
var ruta = rutaFoto.substring(0, rutaFoto.lastIndexOf("/") + 1);
var foto = rutaFoto.substring(rutaFoto.lastIndexOf("/") + 1);
var defaultAvatar = "default-avatar.png";

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
    
    $("#avatar-layout").addClass("avatar-layout");
    $("#avatar").addClass("avatar");
    $("#crop_avatar").attr("onclick","fileChooser()");
    
    if(foto !== defaultAvatar)
    {
        $('#avatarImageShow').show();
    }
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
    
    $("#avatar-layout").removeClass("avatar-layout");
    $("#avatar").removeClass("avatar");
    $("#crop_avatar").removeAttr("onclick",null);
    $("#crop_avatar").attr("src",rutaFoto);
    $('#avatarImageShow').hide();
    $('#avatarImage').val("not modified");

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
            rutaFoto = $("#crop_avatar").attr("src");
            ruta = rutaFoto.substring(0, rutaFoto.lastIndexOf("/") + 1);
            foto = rutaFoto.substring(rutaFoto.lastIndexOf("/") + 1);
        }
    });
}

function fileChooser() {
    $('#imageUpload').trigger('click');
}
function defaultImage(){
    $('#crop_avatar').attr('src', ruta + defaultAvatar);
    $('#avatarImage').val("");
    $('#avatarImageShow').hide();
}

function avatarUpload() {
    //Defining the croppie model
    var $message = $('<div class="demo" id="image_crop"></div>').croppie({
        viewport: {
            width: 250,
            height: 250,
            type: 'circle'
        },
        boundary: {
            width: 300,
            height: 300
        }
    });

    //Creating de crop dialog por de avatar upload
    var dialog = new BootstrapDialog({
        title: 'Haz el corte a tu avatar...',
        message: $message,
        onshown: function () {
            //This function call is important to bind again to an invisible element (in this case, the modal)
            $message.croppie('bind');
        },
        buttons: [
            {
                id: 'btn-ok',
                label: 'Aceptar',
                cssClass: 'btn-primary',
                autospin: true,
                action: function (dialogRef) {
                    $message.croppie('result', {
                        type: 'canvas',
                        size: 'original'
                    }).then(function (src) {
                        $('#crop_avatar').attr('src', src);
                        $('#avatarImage').val(src);
                        $('#avatarImageShow').show();
                    });
                    dialogRef.close();
                }
            },
            {
                id: 'btn-close',
                label: 'Cancelar',
                cssClass: 'btn-danger',
                autospin: false,
                action: function (dialogRef) {
                    dialogRef.close();
                }
            }
        ]
    });
    dialog.realize();

    //Defining variables for the file input and reader
    var file = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();

    //Defining the logic for the event that is called after the upload.
    reader.onloadend = function () {
        $message.croppie('bind', {
            url: reader.result
        });
    };

    //Read the file input (image) as data URL
    if (file) {
        reader.readAsDataURL(file);
    }
    dialog.open();
}