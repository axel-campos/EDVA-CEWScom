$(document).ready(function(){
    var form = "#loginfrm";
    $(form).bootstrapValidator({
        fields:{
            correo:{
                validators: {
                    notEmpty: {
                        message: 'Por favor, ingrese su correo electrónico'
                    },
                    emailAddress: {
                        message: 'El formato del correo no es correcto'
                    }
                }
            },
            password: {
                validators:{
                    notEmpty: {
                        message: 'Por favor, ingrese su contraseña'
                    }
                }
            }
       }
   });
});

function inicioSesionFacebook(correo, nombre, apellido, fecha, imagen){
    var action_ajax = "verificarUsuarioFacebook.action";
    $.post(action_ajax, {"correo": correo, "nombre": nombre, "apellido" : apellido, "fecha": fecha, "imagen": imagen}).done(function(data) 
    {
        $('#contenidos_invisibles').html(data);
        if("Listo" === data.toString().substring(0,5)){
            window.open("indexFacebook.action","_self");
        }else{
            $('label[for="error"]').show(); 
        }
    });   
}
