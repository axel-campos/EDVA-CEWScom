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

