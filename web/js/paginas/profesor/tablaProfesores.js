$(document).ready(function(){
    
    var form = "#frmFiltros";
    var action = "SearchProfesor";
    
    $(form).submit(function(event){
        var i = 0;
        event.preventDefault();
        if($("#nombre").val().trim()){
            i++;
        }
        if($("#cedula").val().trim()){
            i++;
        }
        if($("#correo").val().trim()){
            i++;
        }
        if(i > 1){
            BootstrapDialog.show({
                title: 'Alert',
                message: 'Solo se toma un filtro de los disponibles en el siguiente orden cedula, correo y nombre, Desea continuar?',
                buttons: [{
                    label: 'Sí',
                    cssClass: 'btn-primary',
                    action: function(dialogItself) {
                        dialogItself.close();
                        var datos = $(form).serialize();
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
            var datos = $(form).serialize();
            $.ajax({
                type: "POST",
                url: action,
                data: datos,
                success: function(data){
                    $("#contenido").html(data);
                }
            });
        }
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
    }else{
        return y.outerHeight(true);
    }
}

function eliminarProfesor(correo){
    BootstrapDialog.show({
        title: 'Alert',
        message: 'Está seguro de eliminar al profesor?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                cambiarContenidos("BajaProfesor?correo="+correo,'#contenido');
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

function mostrarInformacion(correo){
    BootstrapDialog.show({
        message: $('<div id="ventana"></div>').load("InformacionProfesor?correo=" + correo),
        title: "Información del profesor",
        buttons: [{
            id: 'btn-info',   
            icon: 'glyphicon glyphicon-ok',       
            label: 'Ok',
            cssClass: 'btn-info', 
            autospin: false,
            action: function(dialogRef){
                dialogRef.close();
            }
        }]
    });
}