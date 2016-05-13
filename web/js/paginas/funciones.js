function cambiarContenidos(pagina, target){
    var destino = target;
    if(pagina !== "#"){
        $(destino).load(pagina,function(){
            $(".button").button();
        });
    }
}

function estasSeguro(pagina,target){
    BootstrapDialog.show({
        title: 'Mensaje',
        message: '¿Está seguro de eliminar este elemento?',
        buttons: [{
            label: 'Sí',
            cssClass: 'btn-primary',
            action: function(dialogItself) {
                dialogItself.close();
                cambiarContenidos(pagina,target);
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


