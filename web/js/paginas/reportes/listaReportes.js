var divs;

$(document).ready(function(){
    var form = "#frmFiltros";
    var action = "listarReportes";
  
    var numDivs = $("#numDivs").val();
    var uls = "";
    divs = new Array();
    
    for(var i = 1; i <= numDivs; i++){
        divs.push($("#div_"+i).html());
        uls += "<li><a  href=\"#\" onclick=\"cambiarContenedor('" + i + "')\" style='cursor:pointer'>Página " + i + "</a></li>";
    }
    
    $("#contenedorReportes").html($("#div_1").html());
    $("#paginacion").html("<ul class=\"breadcrumb\">" + uls + "</ul>");
    
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
});

function cambiarContenedor(numeroDiv){
    $("#contenedorReportes").html(divs[numeroDiv - 1]);
}

function responderReporte(idReporte, respuesta){
    //Respuesta: 1 = aceptado, 0 = rechazado
    var action = "responderReporte?idReporte="+idReporte+"&respuesta="+respuesta;
    
    BootstrapDialog.show({
        title: 'Mensaje',
        message: 'Si acepta el reporte se eliminaran todos los datos relacionados con el elemento, \n\
                ¿Está seguro de eliminar este elemento?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                $.ajax({
                    type: "POST",
                    url: action,
                    success: function(data){
                        if(data.toString().indexOf("Error:") === -1){//No error
                            mensajes(data, TIPO_MENSAJE.SUCCESS);
                            $( "#frmFiltros" ).submit();
                        }else{
                            mensajes(data, TIPO_MENSAJE.DANGER);
                        }
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