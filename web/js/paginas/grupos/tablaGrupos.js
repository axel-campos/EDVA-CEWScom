$(document).ready(function(){
    if($("#msjExito").length > 0){
        mensajes($("#msjExito span").text(),TIPO_MENSAJE.SUCCESS);
        $("#msjExito").html("");
    }else if($("#msjError").length > 0){
        mensajes($("#msjError span").text(), TIPO_MENSAJE.DANGER);
        $("#msjError").html("");
    }
    var form = "#frmFiltros";
    var action = "SearchGroups";
    $(form).submit(function(event){
       event.preventDefault();
       var datos = $(form).serialize();
        $.ajax({
            type: "POST",
            url: action,
            data: datos,
            success: function(data){
                $("#contenido").html(data);
            }
        });
    });
    
    $("#tabla").bootstrapTable({
        height: getHeight(),
        sortName: 'Item ID',
        pageList: [10, 25, 50, 100, 'All'],
        sortable: true,
        pagination: true,
        pageNumber: true,
        search: true,
        minimumCountColumns: 2,
        formatSearch: function(){
            return "Buscar...";
        },
        formatRecordsPerPage: function(pageNumber){
            return pageNumber + " registros por página";
        },
        formatShowingRows: function(pageFrom, pageTo, totalRows){
            return "Mostrando " + pageFrom + " a " + pageTo + " de " + totalRows + " registros";
        },
        formatNoMatches: function(){
            return "Ningún registro coincide con la búsqueda";
        }
    });
});

function getHeight(){
    var columnas = $("#tabla tr").length;
    var y = $('.fixed-table-container');
    if(columnas > 11){
        return $(window).height() - ($('.fixed-table-toolbar').outerHeight(true) + $("#contenedor1").outerHeight(true) + $("#button-group").outerHeight(true) + 14) * 2.7;
        //return (($(window).height() * 3) / 4);// - $("#contenedor1").outerHeight(true);

    }else{
        return y.outerHeight(true);
    }
}

function verificarGrupoVacio(token){
    var action_ajax = "verificarRelacionesGrupo.action";
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

function solicitarIngreso(){
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("enviarSolicitudGrupo"),
        title: "Solicitar Ingreso a Grupo",
        buttons: [{
            id: 'btn-cancel',   
            icon: 'glyphicon glyphicon-remove',       
            label: 'Cerrar',
            cssClass: 'btn-danger', 
            autospin: false,
            action: function(dialogRef){    
                dialogRef.close();
            }
        }],
        draggable: true
    });
}

function crearGrupo(){
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("AltaGroup"),
        title: "Crear nuevo grupo",
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

function modificarGrupo(token){
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("AltaGroup?token=" + token),
        title: "Modificar datos grupo",
        buttons: [{
            id: 'btn-success',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Modificar',
            cssClass: 'btn-success', 
            autospin: false,
            action: function(dialogRef){ 
                submitForm();
                dialogRef.close();
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
    var form = "#altaGrupo";
    $(form).bootstrapValidator().bootstrapValidator('validate');
    //La magia se hace en el archivo altaGrupo.js
    var respuesta = $(form).data("bootstrapValidator").isValid();
    return respuesta; //Nos regresará si el formulario estaba correcto o no.
}
