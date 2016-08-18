$(document).ready(function(){
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
        return $("#contenidoGrupo").height() - ($('.fixed-table-toolbar').outerHeight(true) + $("#contenedor1").outerHeight(true) + 5) * 2.7;//en vez de 5, era 14
        //return (($(window).height() * 3) / 4);// - $("#contenedor1").outerHeight(true);

    }else{
        return y.outerHeight(true);
    }
}

function procesarSolicitud(correo, tipo, numero){
    var mensaje = "";
    var nombre = $("#nombre_" + numero).html();
    var token = $("#token").val();
    if(tipo === "0"){//Aceptado papú
        mensaje = "aceptar";
    }else{
        mensaje = "no aceptar";
    }
    BootstrapDialog.show({
        title: 'Confirmación',
        message: "¿Está seguro de " + mensaje + " la solicitud de " + nombre + "?",
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                var action_ajax = "responderSolicitudGrupo.action";
                $.post(action_ajax, {"token": token, "correo": correo, "tipo": tipo}).done(function(data) 
                {
                    if (data.toString().indexOf("Error:") === -1) {//En caso de que no hay error
                        $('#contenidos_invisibles').html(data); //Es forzoso mostrar el data de respuesta
                        cambiarContenidos('ListarMiembrosAction?token=' + token,'#contenido');
                        mostrarLista('ListSolicitudes?token='+token);
                        mensajes(data,TIPO_MENSAJE.SUCCESS);
                    }else{
                        mensajes(data,TIPO_MENSAJE.WARNING);
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
}