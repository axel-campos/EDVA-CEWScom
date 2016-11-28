function updateTogetherJS(container) {
	var artefactos = MDOUtil.getListaArtefactos(MDOUtil.parseNodeList(document.querySelectorAll(".event")));
	
    if (TogetherJS.running) {
        TogetherJS.send({
            type: 'drop',
            idcontainer: container,
			htmlcontainer: artefactos
        });
    }
	
    TogetherJS.reinitialize();
}

TogetherJS.hub.on('drop', function (msg) {
	if (msg.sameUrl) {
		recrearTimeline(msg.htmlcontainer, msg.idcontainer, false);
		TogetherJS.reinitialize();
	}
});

TogetherJS.hub.on("togetherjs.init-connection", function(msg) {
	if (msg.peerCount === 0) {
		// Recrear Timeline desde el servidor
		recrearTimeline(ARTEFACTOS.artefactos, "#contenidoDidacticoBody", true);
	}
});

TogetherJS.hub.on("togetherjs.hello", function(msg) {
	if (msg.sameUrl) {
		// Ya no se recrea el Timeline, solo se copia lo que lleven los demás.
		var container = "#contenidoDidacticoBody";
		updateTogetherJS(container);
	}
});