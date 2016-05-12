$(document).ready(function(){
    $('#fechaN').datepicker({
        format: "yyyy-mm-dd"
    });
    $('#registrarsefrm').bootstrapValidator({
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
            nombre: {
                validators:{
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
                validators:{
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
            materno:{
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
            cedula:{
                validators:{
                    stringLength:{
                        min: 0,
                        max: 20,
                        message: "El campo cédula no puede tener más de 20 caracteres" 
                    }
                }
            },
            fechaN: {
                validators:{
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
                validators:{
                    notEmpty: {
                        message: 'Por favor, ingrese su contraseña'
                    },
                    stringLength: {
                        max: 60,
                        message: "Su contraseña no puede tener más de 60 caracteres."
                    }
                }
            },
            pwd:{
                message: "Por favor, repita su contraseña para validarla",
                validators:{
                    notEmpty: {
                        message: 'Por favor, ingrede de nuevo su contraseña'
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