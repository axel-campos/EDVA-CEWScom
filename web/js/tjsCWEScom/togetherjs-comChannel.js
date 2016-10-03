/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function updateTogetherJS(container)
{
    if (TogetherJS.running) {
        TogetherJS.send({
            type: 'drop',
            idcontainer: container,
            htmlcontainer: $(container).html()
        });
    }
    TogetherJS.reinitialize();
}

TogetherJS.hub.on('drop', function (msg) {
    if (!msg.sameUrl) {
        return;
    }
    $(msg.idcontainer).html(msg.htmlcontainer);
    TogetherJS.reinitialize();
});


TogetherJS.hub.on("togetherjs.hello", function (msg) {
    var container = "#contenidoDidacticoBody";
    TogetherJS.send({
        type: 'drop',
        container: $(container).html()
    });
    TogetherJS.reinitialize();
});



