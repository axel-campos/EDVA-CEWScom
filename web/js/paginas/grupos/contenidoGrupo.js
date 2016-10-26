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
        if(type === "success"){
            mensajes(message, TIPO_MENSAJE.SUCCESS);
        }else if(type === "danger"){
            mensajes(message, TIPO_MENSAJE.DANGER);
        }else if(type === "info"){
            mensajes(message, TIPO_MENSAJE.INFO);
        }
        
        //mostrarNotificacion(type, message);
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

function mostrarDisqus(idContenido){
    
    BootstrapDialog.show({
        message: $('<div id="ventanaDisqus"></div>').load("verDisqus", {"idContenido": idContenido}),
        title: "Foro del contenido",
        buttons: [{
            id: 'btn-info',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Listo',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                var resultado = submitForm();
                if(resultado){//true, quiere decir que todo bien
                    dialogRef.close();
                }
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

function cargarFormulario(id, etapa, version){
    //var token = $("#token").val();
    if(etapa === "null"){etapa = "";}
    if(version === "null"){version = "";}
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("cargaEtapas", {"idContenido": id, etapa: etapa, version: version}),
        title: "Establecer tiempo de modificación",
        buttons: [{
            id: 'btn-cancel',   
            icon: 'glyphicon glyphicon-thumbs-up',       
            label: 'OK',
            cssClass: 'btn-primary', 
            autospin: false,
            action: function(dialogRef){    
                dialogRef.close();
            }
        }]
    });
}

function modificarContenido(id){
    var token = $("#token").val();
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("altaContenido", {"token": token, id: id}),
        title: "Modificar información del contenido didáctico",
        buttons: [{
            id: 'btn-success',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Modificar',
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

function eliminaContenido(id){
    var token = $("#token").val();
    BootstrapDialog.show({
        title: 'Mensaje',
        message: '¿Está seguro de eliminar este contenido didáctico?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                $.post("eliminarContenido",{id: id}).done(function(data){
                    cambiarContenidos('ListarMiembrosAction?token='+token,'#contenido');
                    var target = "#contenidoGrupo";
                    $(target).html(data);
                });
                
                
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
function terminaVersion(id, etapa, version){
    var token = $("#token").val();
    BootstrapDialog.show({
        title: 'Mensaje',
        message: '¿Está seguro de terminar el tiempo de esta versión?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                $.post("terminaVersion",{"idContenido": id, etapa: etapa, version: version}).done(function(data){
                    cambiarContenidos('ListarMiembrosAction?token='+token,'#contenido');
                    var target = "#contenidoGrupo";
                    $(target).html(data);
                });
                
                
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
function mostrarVotacion(idContenido){
    BootstrapDialog.show({
        message: $('<div id="ventanaVotacion"></div>').load("verVotacion", {"idContenido": idContenido}),
        title: "Votación por etapas",
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
