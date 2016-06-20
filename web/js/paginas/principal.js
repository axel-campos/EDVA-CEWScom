function responderSolicitud(token, correo, tipo, div){
    //Tipo 0 = aceptar, 1 = rechazar
    var action_ajax = "responderSolicitudGrupo.action";
    $.post(action_ajax, {"token": token, "correo": correo, "tipo": tipo}).done(function(data) 
    {
        if (data.toString().indexOf("Error:") === -1) {/*En caso de que no hay error*/ 
            $('#contenidos_invisibles').html(data); //Es forzoso mostrar el data de respuesta
            mensajes(data,3);
        }else{
            mensajes(data,5);
        }    
    });  
}

