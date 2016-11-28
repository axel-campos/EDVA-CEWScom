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
                cambiarContenidos('ListarContenidosGrupoAction?token='+token,'#contenido');
                var target = "#contenidoGrupo";
                $(target).html(data);
            },
            error: function(data){
                var token = $("#token").val();
                //Se actualiza la pantalla para que ya aparezcan las opciones de establecer tiempos de modificación
                cambiarContenidos('ListarContenidosGrupoAction?token='+token,'#contenido');
                var target = "#contenidoGrupo";
                $(target).html(data);
            }
        });
    });
});

function modificarVotacion(){
    $("#principalVotacion").show();
    $("#btn-info").show();
    $("#modificarVoto").html($("#principalVotacion"));
}

function visualizarContenido(token, idContenido, idEtapa, version){
    var action_ajax = "descargarHTML.action";
    $.post(action_ajax, {"token": token, "idContenido": idContenido, "idEtapa": idEtapa, "version": version}).done(function(data) 
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


