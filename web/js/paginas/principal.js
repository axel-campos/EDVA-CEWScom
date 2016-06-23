function responderSolicitud(token, correo, tipo, div){
    //Tipo 0 = aceptar, 1 = rechazar
    var action_ajax = "responderSolicitudGrupo.action";
    $.post(action_ajax, {"token": token, "correo": correo, "tipo": tipo}).done(function(data) 
    {
        if (data.toString().indexOf("Error:") === -1) {//En caso de que no hay error
            $('#contenidos_invisibles').html(data); //Es forzoso mostrar el data de respuesta
            mensajes(data,TIPO_MENSAJE.SUCCESS);
        }else{
            mensajes(data,TIPO_MENSAJE.WARNING);
        }    
    });
    var noItems = $("#noItems").val();
    //Vamos a quitar el item de la lista
    $( "#item"+div ).remove();
    if(noItems == 1){
        $(".carousel-inner").append("<div class='item active'>"+
                                    "<div class='carousel-content'>"+
                                    "<div>"+
                                    "<p style='font-family: verdana; font-size: 11px'>No hay más solicitudes que atender en tus grupos</p>"+
                                    "</div></div></div>");
    }
    $('#text-carousel').find('.item').first().addClass('active');
    //Después de actualizar los items tenemos que refrescar el carousel
    $("#main-navigation-carousel").carousel("pause").removeData();
    $("#main-navigation-carousel").carousel(1);
}

