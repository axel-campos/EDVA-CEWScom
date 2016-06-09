$(document).ready(function(){
    var form1 = "#accesofrm";
    var action1 = "verificarTokenAcceso.action";
    $(form1).bootstrapValidator({
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
        fields:{
            token:{
                validators:{
                    notEmpty: {
                        message: "Por favor, ingrese el token del grupo."
                    }
                }
            }
        }
    }).on('success.form.fv', function(e){
        //Prevent form submission
        e.preventDefault();
        $("#correcto").hide();
        $("#incorrecto").hide();
        //Use Ajax to submit form data
        var token = $("#token").val();
        $.post(action1, {"token": token}).done(function(data) 
        {
            if(data.toString().indexOf("Error:") === -1){//No error
                //var datos = data.split("**");
                //alert(datos);
                /*$("#tr_token").html(datos[0]);
                $("#tr_nombre").html(datos[1]);
                $("#tr_desc").html(datos[2]);
                $("#tr_participantes").html(datos[3]);*/
                $("#tb_grupo").html(data);
                $("#correcto").show();
            }else{
                $("#incorrecto").show();
            }
        });
    }); 
});



/*function buscarPorToken()
{
    var token = document.getElementById("token").value;
    $("#contenidos_invisibles").html(token);
    var action_ajax = "Actions.Groups.AccesoGrupoAction";
    $.post(action_ajax, {"token": token}).done(function(data) 
    {
        if (data.toString().indexOf("Error:") === -1) {//En caso de que no hay error
            $('#contenidos_invisibles').html(data);
            if("Si" === data.toString().substring(0, 2))
            {
                BootstrapDialog.show({
                    title: 'Alert',
                    message: 'Este grupo tiene datos asociados, Está seguro de eliminarlo?',
                    buttons: [{
                        label: 'Sí',
                        cssClass: 'btn-primary',
                        action: function(dialogItself) {
                            dialogItself.close();
                            cambiarContenidos("BajaGroup?token="+token,'#contenido');
                        }
                    }, {
                        label: 'No',
                        cssClass: 'btn-warning',
                        action: function(dialogItself){
                            dialogItself.close();
                        }
                    }]
                });
            }
            else
            {
                estasSeguro("BajaGroup?token="+token,'#contenido');
            }
       }
    }); 
}*/


