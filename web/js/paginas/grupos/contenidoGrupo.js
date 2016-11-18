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
        }],
        draggable: true
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
        }],
        draggable: true
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
        title: "Establecer tiempo de modificación"
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
        }],
        draggable: true
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
                    cambiarContenidos('ListarContenidosGrupoAction?token='+token,'#contenido');
                });
                
                
            }
        }, {
            label: 'No',
            cssClass: 'btn-warning',
            action: function(dialogItself){
                dialogItself.close();
            }
        }],
        draggable: true
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
                    cambiarContenidos('ListarContenidosGrupoAction?token='+token,'#contenido');
                });
                
                
            }
        }, {
            label: 'No',
            cssClass: 'btn-warning',
            action: function(dialogItself){
                dialogItself.close();
            }
        }],
        draggable: true
    });
}

function finalizarVotacion(idContenido, token){
    BootstrapDialog.show({
        message: $('<div id="ventanaFinalizaVotacion"></div>').load("finalizarVotacion", {"idContenido": idContenido, "token": token}),
        title: "Finalizar Votación",
        draggable: true,
        buttons: [{
            id: 'btn-info',   
            icon: 'glyphicon glyphicon-ok',     
            draggable: true,
            label: 'Finalizar Votación',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){
                var resultado = submitFormGeneral("#finalizarVotacionForm");
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

function mostrarInfoGrupo(nombre, descripcion){
    BootstrapDialog.show({
        /*size: BootstrapDialog.SIZE_LARGE,*/
        message: 'Hi Apple!',
        title: 'Información del grupo',
        buttons: [{
            label: 'Button 1'
        }, {
            label: 'Button 2',
            cssClass: 'btn-primary',
            action: function(){
                alert('Hi Orange!');
            }
        }, {
            icon: 'glyphicon glyphicon-ban-circle',
            label: 'Button 3',
            cssClass: 'btn-warning'
        }, {
            label: 'Close',
            action: function(dialogItself){
                dialogItself.close();
            }
        }]
    });
}
