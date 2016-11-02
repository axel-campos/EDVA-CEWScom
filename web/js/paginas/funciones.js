$(document).ready(function(){
    window.location.hash="no-back-button";
    window.location.hash="Again-No-back-button" //chrome
    window.onhashchange=function(){window.location.hash="no-back-button";} 
});
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
            if (TogetherJS.running) {
                TogetherJS();
                TogetherJS.require("storage").tab.clear("status");
                console.log("End Of Together");
            }
            
            finalizar();
            if(data.toString().indexOf("Regístrate") === -1){
                $(target).html(data); 
            }else{
                var cwescom = "cwescom.action";
                window.open(cwescom,'_top');
            }
            
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

/**
* Permite crear un reporte de cualquier tipo
* 
* @param {int} tipoReporte 1 = contenido, 2 = grupos, 3 = profesor
* @param {valor} valor Si es el contenido este valor es el idContenido, para grupos token y para profesor correo
* @param {extra} extra 
* @return 
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
                    if(tipoReporte != 2){
                        mensajes("El reporte se ha creado con éxito", 3);
                    }   
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

function mostrarVotacion(idContenido, token){
    BootstrapDialog.show({
        message: $('<div id="ventanaVotacion"></div>').load("verVotacion", {"idContenido": idContenido, "token": token}),
        title: "Votación por etapas",
        draggable: true,
        buttons: [{
            id: 'btn-info',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Votar',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                var resultado = submitFormGeneral("#votacionForm");
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

function submitFormGeneral(form){
    $(form).bootstrapValidator().bootstrapValidator('validate');
    //La magia se hace en el archivo js
    var respuesta = $(form).data("bootstrapValidator").isValid();
    return respuesta; //Nos regresará si el formulario estaba correcto o no.
}

