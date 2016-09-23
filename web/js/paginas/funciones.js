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
//mensajes("Jajatl", TIPO_MENSAJE.SUCCESS);

function mostrarNotificacion(type, message){
    $.notify({
        // options
        message: message 
    },{
        // settings
        type: type
    });
}


/**
 * Crea una ventana emergente para crear un reporte de cualquier tipo
 * 
 * @param {int} tipoReporte El tipo de reporte que haremos
 * @param {string} valor Puede ser el correo, token o idContenido
 */
function crearReporte(tipoReporte, valor, extra){
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("CrearReporte?tipoReporte=" + tipoReporte + "&valor=" + valor + "&extra=" + extra),
        title: "Crear nuevo reporte",
        buttons: [{
            id: 'btn-success',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Crear',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                var resultado = submitForm2();
                if(resultado){//true, quiere decir que todo bien
                    dialogRef.close();
                }
            }
        },{
            id: 'btn-cancel',   
            icon: 'glyphicon glyphicon-remove',       
            label: 'Cancelar',
            cssClass: 'btn-danger', 
            autospin: false,
            action: function(dialogRef){    
                dialogRef.close();
            }
        }]
    });
}

function submitForm2(){
    var form = "#reporte";
    $(form).bootstrapValidator().bootstrapValidator('validate');
    //La magia se hace en el archivo altaGrupo.js
    var respuesta = $(form).data("bootstrapValidator").isValid();
    return respuesta; //Nos regresará si el formulario estaba correcto o no.
}
