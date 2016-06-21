 

function inicioSesionFacebook(correo, nombre, apellido, fecha){
    var action_ajax = "verificarUsuarioFacebook.action";
    $.post(action_ajax, {"correo": correo, "nombre": nombre, "apellido" : apellido, "fecha": fecha}).done(function(data) 
    {
        $('#contenidos_invisibles').html(data);
        if("Listo" === data.toString().substring(0,5)){
            window.open("indexFacebook.action","_self");
        }else{
            $('label[for="error"]').show(); 
        }
    });   
}
