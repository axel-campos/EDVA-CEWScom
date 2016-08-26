$(document).ready(function(){
    var form = "#frmFiltros";
    var action = "listarReportes";
    
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


