$(document).ready(function(){
    var form = "#votacionForm";
    var action = "registrarVotacion";
    $(form).bootstrapValidator({
        autofocus: true,
        elementClass: 'fv-form',
        icon:{
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon  glyphicon-refresh'
        },
        events: {
            formInit: 'init.form.fv',
            formError: 'err.form.fv',
            formSuccess: 'success.form.fv',
            fieldAdded: 'added.field.fv',
            fieldRemoved: 'removed.field.fv',
            fieldInit: 'init.field.fv',
            fieldError: 'err.field.fv',
            fieldSuccess: 'success.field.fv',
            fieldStatus: 'status.field.fv',
            localeChanged: 'changed.locale.fv',
            validatorError: 'err.validator.fv',
            validatorSuccess: 'success.validator.fv'
        },
        fields: {
            etapa1: {
                validators: {
                    notEmpty: {
                        message: "Por favor, seleccione una versión para la etapa 1."
                    }
                }
            },
            etapa2: {
                validators: {
                    notEmpty: {
                        message: "Por favor, seleccione una versión para la etapa 2."
                    }
                }
            },
            etapa3: {
                validators: {
                    notEmpty: {
                        message: "Por favor, seleccione una versión para la etapa 3."
                    }
                }
            },
            etapa4: {
                validators: {
                    notEmpty: {
                        message: "Por favor, seleccione una versión para la etapa 4."
                    }
                }
            },
            etapa5: {
                validators: {
                    notEmpty: {
                        message: "Por favor, seleccione una versión para la etapa 5."
                    }
                }
            }
        }               
    }).on('success.form.fv', function(e, data){
        //Prevent form submission
        e.preventDefault();
        //Use Ajax to submit form data
        var datos = $(form).serialize();
        $.ajax({
            type: "POST",
            url: action,
            data: datos,
            success: function(data){
                mensajes("Éxito al registrar su votación", TIPO_MENSAJE.SUCCESS);
            },
            error: function(data){
                mensajes("Hubo un problema al registrar la votación, inténtelo de nuevo", TIPO_MENSAJE.WARNING);
            }
        });
    });
});


