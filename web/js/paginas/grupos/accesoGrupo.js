/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function buscarPorToken()
{
    var token = document.getElementById("token").value;
    var action_ajax = "Actions.Groups.AccesoGrupoAction";
    $.post(action_ajax, {"token": token}).done(function(data) 
    {
        if (data.toString().indexOf("Error:") === -1) {/*En caso de que no hay error*/ 
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
}


