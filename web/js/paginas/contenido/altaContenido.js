$(document).ready(function(){
    var form = "#altaContenido";
    var action = "crearContenido";
    
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
            titulo: {
                validators: {
                    notEmpty: {
                        message: "Por favor, ingrese el titulo del contenido."
                    },
                    stringLength:{
                        max: 20,
                        message: 'La cantidad máxima de letras para el título es de 20.'
                    }
                }
            },
            tema:{
                validators:{
                    stringLength:{
                        min: 0,
                        max: 20,
                        message: 'La cantidad máxima de letras para el tema es de 20.'
                    }
                }
            },
            descripcion: {
                validators:{
                    stringLength:{
                        min: 0,
                        max: 1000,
                        message: 'La cantidad máxima de letras para la descripción es de 1000.'
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
                var token = $("#token").val();
                //Se actualiza la pantalla para que ya aparezcan las opciones de establecer tiempos de modificación
                cambiarContenidos('ListarMiembrosAction?token='+token,'#contenido');
                var target = "#contenidoGrupo";
                $(target).html(data);
            }
        });
    });
});