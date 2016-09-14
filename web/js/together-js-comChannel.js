/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function updateTogetherJS(html)
{
    if (TogetherJS.running) {
        TogetherJS.send({
            type: 'drop',
            container: html
        });
    }
    TogetherJS.reinitialize();
}

TogetherJS.hub.on('drop', function (msg) {
  if (!msg.sameUrl) {
      return;
  }
  $("#contenidoDidacticoBody").html(msg.container);
  TogetherJS.reinitialize();
});


TogetherJS.hub.on("togetherjs.hello", function (msg) {
    TogetherJS.send({
        type: 'drop',
        container: $("#contenidoDidacticoBody").html()
    });
    TogetherJS.reinitialize();
});




