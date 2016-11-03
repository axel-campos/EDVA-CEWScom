$(document).ready(function(){
    var form = "#frmFiltros";
    var action = "listarContenidos";
    
    $("#fechaInicio").datetimepicker({
        locale: 'es',
        format: 'YYYY-MM-DD'
    });
    $("#fechaFin").datetimepicker({
        locale: 'es',
        format: 'YYYY-MM-DD'
    });
    
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
            fechaInicio: {
                validators: {
                    regexp: {
                        regexp: /^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/,
                        message: 'El formato de la fecha (yyyy-[m]m-[d]d) no es correcta'
                    }
                }
            },
            fechaFin: {
                validators: {
                    regexp: {
                        regexp: /^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$/,
                        message: 'El formato de la fecha (yyyy-[m]m-[d]d) no es correcta'
                    }
                }
            }
        }
    }).on('success.form.fv', function(e){
       e.preventDefault();
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

function visualizarContenidoFinalizado(token, idContenido){
    var action_ajax = "descargarHTMLFinalizado.action";
    $.post(action_ajax, {"token": token, "idContenido": idContenido}).done(function(data) 
    {
        if (data.toString().indexOf("Error:") === -1) {//En caso de que no hay error
            window.open(
              data,
              '_blank' // <- This is what makes it open in a new window.
            );
        }else{
            mensajes(data,TIPO_MENSAJE.WARNING);
        }    
    });
}

