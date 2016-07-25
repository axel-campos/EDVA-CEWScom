// Tipos de mensajes a mostrar
var TIPO_MENSAJE = {
    DEFAULT: 0,
    INFO: 1,
    PRIMARY: 2,
    SUCCESS: 3,
    WARNING: 4,
    DANGER: 5
};

function cambiarContenidos(pagina, target){
    cargando();
    $.post(pagina)
    .done(function(data){
        setTimeout(
        function() 
        {
            finalizar();
            $(target).html(data);
        }, 1000);
    }).fail(function(data){
        errorCargando();
    });
}

function cargando(){
    $("#cargando").show();
    $("#errorPrincipal").hide();
    $("#contenido").hide();
}

function finalizar(){
    $("#cargando").hide();
    $("#contenido").show();
}

function errorCargando(){
    $("#cargando").hide();
    $("#errorPrincipal").show();
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

// Así mandas a llamar a la funcion, Vic.
//mensajes("Putos todos", TIPO_MENSAJE.SUCCESS);