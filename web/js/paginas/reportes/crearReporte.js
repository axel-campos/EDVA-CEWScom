$(document).ready(function(){
   var form = "#reporte";
   var action = "altaReporte";
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
            causa: {
                validators: {
                    notEmpty: {
                        message: "Por favor, ingrese la causa del reporte."
                    },
                    stringLength:{
                        max: 200,
                        message: 'La cantidad máxima de letras para la causa es de 200'
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
                var target = "#contenido";
                $(target).html(data);
            }
        });
    }); 
});


