var divs;

$(document).ready(function(){
    var numDivs = $("#numDivs").val();
    var uls = "";
    divs = new Array();
    
    for(var i = 1; i <= numDivs; i++){
        divs.push($("#div_"+i).html());
        uls += "<li><a  href=\"#\" onclick=\"cambiarContenedor('" + i + "')\" style='cursor:pointer'>Página " + i + "</a></li>";
    }
    
    $("#contenedorContenidos").html($("#div_1").html());
    $("#paginacion").html("<ul class=\"breadcrumb\">" + uls + "</ul>");
    
    var message = $("#message").val();
    var type = $("#type").val();
    if(message !== "" && type !== ""){
        mostrarNotificacion(type, message);
    }
});

function crearContenido(){
    var token = $("#token").val();
    
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("altaContenido", {"token": token}),
        title: "Crear nuevo contenido didáctico",
        buttons: [{
            id: 'btn-success',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Crear',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                var resultado = submitForm();
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

function submitForm(){
    var form = "#altaContenido";
    $(form).bootstrapValidator().bootstrapValidator('validate');
    //La magia se hace en el archivo altaContenido.js
    var respuesta = $(form).data("bootstrapValidator").isValid();
    return respuesta; //Nos regresará si el formulario estaba correcto o no.
}

function cambiarContenedor(numeroDiv){
    $("#contenedorContenidos").html(divs[numeroDiv - 1]);
}

function cargarFormulario(id){
    //var token = $("#token").val();
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("cargaEtapas", {"idContenido": id}),
        title: "Establecer tiempo de modificación",
        buttons: [{
            id: 'btn-success',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Crear',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                //var resultado = submitForm();
                //if(resultado){//true, quiere decir que todo bien
                    dialogRef.close();
                //}
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
