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
