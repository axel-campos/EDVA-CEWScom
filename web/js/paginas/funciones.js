function cambiarContenidos(pagina, target){
    var destino = target;
    if(pagina !== "#"){
        $(destino).load(pagina,function(){
            $(".button").button();
        });
    }
}

function estasSeguro(pagina,target){
    BootstrapDialog.show({
        title: 'Mensaje',
        message: '¿Está seguro de eliminar este elemento?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                cambiarContenidos(pagina,target);
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

/**
* Permite mostrar un mensaje con BootstrapDialog, de diferentes tipos
* 
* @param {String} mensaje El mensaje a mostrar
* @param {int} tipo 0 = DEFAULT, 1 = INFO, 2 = PRIMARY, 3 = SUCCESS, 4 = WARNING, 5 = DANGER
* @return La referencia a este contenido-etapa.
*/
function mensajes(mensaje, tipo){
    var types = [BootstrapDialog.TYPE_DEFAULT, 
                     BootstrapDialog.TYPE_INFO, 
                     BootstrapDialog.TYPE_PRIMARY, 
                     BootstrapDialog.TYPE_SUCCESS, 
                     BootstrapDialog.TYPE_WARNING, 
                     BootstrapDialog.TYPE_DANGER];
                     
    BootstrapDialog.show({
        type: types[tipo],
        title: 'Mensaje: ',
        message: mensaje
    });     
}


