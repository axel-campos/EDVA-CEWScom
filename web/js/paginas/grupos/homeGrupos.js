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
