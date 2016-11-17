$(document).ready(function(){
    var height = $(window).height();
    var utilizado = ($("#header").outerHeight() + 5);//antes era 14
    var altura = (height - utilizado);
    $("#contenidoGrupo").height(altura);
});

function mostrarLista(pagina,token){
    $("#navegacion").empty();
    if(pagina.toString().indexOf("ListRoles") !== -1){
        $("#navegacion").append("<li><a href=\"#\">CWEScom</a></li>" +
                "<li><a href=\"#\">Mis grupos</a></li>" +
                "<li><a href=\"#\">Contenidos grupo</a></li>" +
                "<li><a href=\"#\">Roles de grupo</a></li>");
    }else if(pagina.toString().indexOf("ListSolicitudes") !== -1){
        $("#navegacion").append("<li><a href=\"#\">CWEScom</a></li>" +
                "<li><a href=\"#\">Mis grupos</a></li>" +
                "<li><a href=\"#\">Contenidos grupo</a></li>" +
                "<li><a href=\"#\">Solicitudes de grupo</a></li>");
    }else if(pagina.toString().indexOf("ListarContenidosGrupoAction") !== -1){
        $("#navegacion").append("<li><a href=\"#\">CWEScom</a></li>" +
                "<li><a href=\"#\">Mis grupos</a></li>" +
                "<li><a href=\"#\">Contenidos grupo</a></li>");
    }
    $("#contenidoGrupo").load(pagina,{"token": token});
}