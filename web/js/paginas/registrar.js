/* global dialog, FileReader */
$(document).ready(function () {
    $('#fechaN').datepicker({
        format: "yyyy-mm-dd"
    });
    $('#registrarsefrm').bootstrapValidator({
        fields: {
            correo: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su correo electrónico'
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
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su contraseña'
                    },
                    stringLength: {
                        max: 60,
                        message: "Su contraseña no puede tener más de 60 caracteres."
                    }
                }
            },
            pwd: {
                message: "Por favor, repita su contraseña para validarla",
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese de nuevo su contraseña'
                    },
                    identical: {
                        field: "password",
                        message: "Las contraseñas no coinciden"
                    }
                }
            }
        }
    });
});

function fileChooser() {
    $('#imageUpload').trigger('click');
}
function defaultImage(){
    var defaultImage = "images/default-avatar.png";
    $('#crop_avatar').attr('src', defaultImage);
    $('#avatarImage').val("");
    $('#defaultImage').hide();
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
                        $('#defaultImage').show();
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
