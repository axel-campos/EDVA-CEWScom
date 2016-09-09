$(document).ready(function(){
    var height = $(window).height();
    var utilizado = ($("#header").outerHeight() + 5);//antes era 14
    var altura = (height - utilizado);
    $("#contenidoGrupo").height(altura);
});

function mostrarLista(pagina,token){
    $("#contenidoGrupo").load(pagina,{"token": token});
}