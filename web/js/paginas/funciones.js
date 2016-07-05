// Tipos de mensajes a mostrar
var TIPO_MENSAJE = {
    DEFAULT: 0,
    INFO: 1,
    PRIMARY: 2,
    SUCCESS: 3,
    WARNING: 4,
    DANGER: 5
};

var TIPO_ESTATUS = {
    SUCCESS: 'complete',
    ERROR: 'error'
};

function cambiarContenidos(pagina, target){    
    var progress1 = loading(10)
    if(pagina !== "#"){
        $(target).load(pagina,function(response, status, xhr){
            if(status === "success"){
                finished(progress1, TIPO_ESTATUS.SUCCESS);
            }
            $(".button").button();
        });
    }
}

function loading(tiempo){
    $("#progressBar").show();
    return $("#progressBar").progressTimer({
        timeLimit: tiempo,
        onFinish: function () {
        }
    });
}

function finished(progress, tipo){
    var mensaje = "";
    if(tipo === TIPO_ESTATUS.SUCCESS){
        mensaje = "¡Éxito!";
    }else{
        mensaje = "¡Error!";
    }
    progress.progressTimer(tipo, {
        successText : mensaje,
        onFinish: function(){
            $("#progressBar").hide();
        }
    });
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