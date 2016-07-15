$(document).ready(function(){
    var height = $(window).height();
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
});

function abrirVentana1(){
    var c = $("#informacion").prop("class");
    if(c === "dropdown"){
        $("#informacion").prop("class","dropup");
    }else if(c === "dropup"){
        $("#informacion").prop("class","dropdown");
    }
}

function abrirVentana2(){
    var c = $("#miembros").prop("class");
    if(c === "dropdown"){
        $("#miembros").prop("class","dropup");
    }else if(c === "dropup"){
        $("#miembros").prop("class","dropdown");
    }
}