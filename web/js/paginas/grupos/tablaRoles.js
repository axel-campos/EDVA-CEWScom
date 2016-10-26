$(document).ready(function(){
    if($("#msjExito").length > 0){
        mensajes($("#msjExito span:last").text(), TIPO_MENSAJE.SUCCESS);
    }else if($("#msjError").length > 0){
        mensajes($("#msjError span:last").text(), TIPO_MENSAJE.DANGER);
    }    
    
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
        return $("#contenidoGrupo").height() - ($('.fixed-table-toolbar').outerHeight(true) + $("#contenedor1").outerHeight(true) + 14) * 2.7;
        //return (($(window).height() * 3) / 4);// - $("#contenedor1").outerHeight(true);

    }else{
        return y.outerHeight(true);
    }
}

function ModificarRoles(){
    var numRows = $("#numMiembros").val();
    //$("#colEliminar").show();
    $("#tabla").bootstrapTable('showColumn','Eliminar');
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(0).disabled = false;
        document.getElementsByName("txt_result_" + x).item(1).disabled = false;
        //$("#rowEliminar_" + x).show();
    }
    //escondemos
    $("#modify_button").hide();
    $("#new_coordinator_button").hide();
    //mostramos
    $("#submit_button").show();
    $("#cancelar_button").show();
}

function NuevoCoordinador(){
    var numRows = $("#numMiembros").val();
    //$("#colCoordinador").show();
    $("#tabla").bootstrapTable('showColumn','Coordinador');
    for(x = 0; x < numRows; x++){
        document.getElementsByName("txt_result_" + x).item(0).disabled = false;
        //$("#rowCoordinador_" + x).show();
    }    
    //escondemos
    $("#modify_button").hide();
    $("#new_coordinator_button").hide();
    //mostramos
    $("#coordinador_submit_button").show();
    $("#cancelar_button").show();
}

function cancel_operation(){
    /*Desaparecer columnas*/
    var numRows = $("#numMiembros").val();
    //Escondemos filas
    $("#tabla").bootstrapTable('hideColumn','Eliminar');
    $("#tabla").bootstrapTable('hideColumn','Coordinador');
    //$("#colEliminar").hide();
    //$("#colCoordinador").hide();
    for(x = 0; x < numRows; x++){
        var radiobutton1 = document.getElementsByName("txt_result_" + x).item(0);
        var radiobutton2 = document.getElementsByName("txt_result_" + x).item(1);
        //var radiobutton3 = document.getElementsByName("txt_result_" + x).item(2);
        radiobutton1.disabled = true;
        radiobutton2.disabled = true;
        //radiobutton3.disabled = true;
        if(radiobutton1.checked){
            radiobutton1.checked = false;
        }else if(radiobutton2.checked){
            radiobutton2.checked = false;
        }/*else if(radiobutton3.checked){
            radiobutton3.checked = false;
        }*/
        //$("#rowEliminar_" + x).hide();
        //$("#rowCoordinador_" + x).hide();
    }
    /*Reset al formulario*/
    document.getElementById("frmRoles").reset();    
    
    /*Botones*/
    //escondemos
    $("#submit_button").hide();
    $("#coordinador_submit_button").hide();
    $("#cancelar_button").hide();
    //mostramos    
    $("#modify_button").show();
    $("#new_coordinator_button").show();
}

function guardarCambiosRoles(){
    //Mandamos datos por ajax
    var form = "#frmRoles";
    var action = "modifyRoles";
    
    var datos = $(form).serialize();
    $.ajax({
        type: "POST",
        url: action,
        data: datos,
        success: function(data){
            $("#contenidoGrupo").html(data);
        }
    });
}

function asignarNuevoCoordinador(){
    var numRows = $("#numMiembros").val();
    var numeroAsignados = 0;
    for(x = 0; x < numRows; x++){
        var radiobutton1 = document.getElementsByName("txt_result_"+x).item(0);
        if(radiobutton1.checked){
            numeroAsignados += 1;
        }
    }
    if(numeroAsignados === 0){
        BootstrapDialog.alert("No ha asignado a ningún coordinador nuevo");
    }else if(numeroAsignados === 1){
        //Mandamos datos por ajax
        var form = "#frmRoles";
        var action = "setCoordinadorAction";
        var datos = $(form).serialize();
        BootstrapDialog.show({
            title: 'Alert',
            message: '¿Seguro que desea asignar un nuevo Coordinador? Recuerde que una vez hecho esto, usted cambiará al perfil administrador',
            buttons: [{
                label: 'Sí',
                cssClass: 'btn-primary',
                action: function(dialogItself) {
                    dialogItself.close();
                    $.ajax({
                        type: "POST",
                        url: action,
                        data: datos,
                        success: function(data){
                            $("#contenido").html(data);
                        }
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
        
    }else{
        BootstrapDialog.alert("¡Usted no puede asignar más de un coordinador!");
        for(x = 0; x < numRows; x++){
            var radiobutton1 = document.getElementsByName("txt_result_"+x).item(0);
            if(radiobutton1.checked){
                radiobutton1.checked = false;
            }
        }
        /*Reset al formulario*/
        document.getElementById("frmRoles").reset();
    }
}

function eliminarMiembro(numRow){
    BootstrapDialog.show({
        title: 'Alert',
        message: '¿Está seguro que quiere eliminar a este miembro de su grupo?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                var token = $("#token").val();
                var correo = $("#txt_correo_" + numRow).val();
                cambiarContenidos("eliminarMiembroAction?correo="+correo+"&token="+token,"#contenidoGrupo");
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