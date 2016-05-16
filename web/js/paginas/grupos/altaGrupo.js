$(document).ready(function(){
   var form = "#altaGrupo";
   var action = "altaGrupo";
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
            nombre: {
                validators: {
                    notEmpty: {
                        message: "Por favor, ingrese el nombre de su grupo."
                    },
                    stringLength:{
                        max: 40,
                        message: 'La cantidad máxima de letras para el nombre es de 40'
                    },
                    callback: {
                        message: 'El nombre del grupo debe iniciar y terminar con una letra o un número',
                        callback: function(value, validator, $field){
                            var valueLength = value.length;
                            var letras = "abcdefghijklmnopqrstuvwxyz";
                            var numeros = "1234567890";
                            var letraInicial = value.charAt(0).toLowerCase();
                            var letraFinal = value.charAt(valueLength - 1).toLowerCase();
                            return (letras.indexOf(letraInicial) !== -1 || numeros.indexOf(letraInicial) !== -1) && (letras.indexOf(letraFinal) !== -1 || numeros.indexOf(letraFinal) !== -1);
                        }
                    }
                }
            },
            descripcion: {
                validators:{
                    stringLength:{
                        min: 0,
                        max: 100,
                        message: 'La cantidad máxima de letras para la descripción es de 100.'
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
                $("#contenido").html(data);
            }
        });
    }); 
});