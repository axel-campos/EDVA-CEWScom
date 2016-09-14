$(document).ready(function(){
	populateArtefactos();
	agregarDragAndDrop("#documentacionPanelBody", "DocumentacionFactory");
	
	$("#btnGuardar").click(function() {
		var listaArtefactos = MDOUtil.parseNodeList(document.querySelectorAll(".event"));
		$("#header .alert").remove();
		
		if (listaArtefactos.length > 0) {
			var artefactos = MDOUtil.getListaArtefactos(listaArtefactos, "Documentacion", "Contenido de Ejemplo", "CFH765KHSIUH");
			console.log(artefactos);
			/*$.ajax({
				url: APP_BASE + "/mdocontenido/GuardarProgreso",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(artefactos),
				success: function(response) {
					$("#header").append("\
						<div class='alert alert-success'>\n\
							<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>\n\
							" + response.message + "\n\
						</div>");
				}
			});*/
		}
	});

	$("#btnDescargar").click(function() {
		$.post(APP_BASE + "/mdocontenido/DescargarContenido", {}, function(response) {
			alert(response.stateMap.message);
		});
	});
});

/**
 * Agrega la funcionalidad de Drag and Drop al selector de artefactos MDO
 * y al área de trabajo de los contenidos didácticos.
 * 
 * @param {string} selector ID de jQuery del selector de artefactos
 * @param {type} nombreFabrica El nombre de la fábrica MDO a utilizar.
 */
function agregarDragAndDrop(selector, nombreFabrica) {
	dragula([
		document.querySelector(selector),
		document.querySelector("#contenidoDidacticoBody")
	], {
		copy: function(el, source) {
			return source === document.querySelector(selector);
		},
		accepts: function(el, target) {
			return target !== document.querySelector(selector);
		},
		removeOnSpill: true
	}).on("drag", function(el) {
		el.className = el.className.replace("ex-moved", "");
        updateTogetherJS( $("#contenidoDidacticoBody").html() );
	}).on("drop", function(el) {
		var nombreArtefacto = el.className.replace("gu-transit", "").trim();
		if (!el.className.includes("mdo-")) {
			var artefacto = MDOFactories[nombreFabrica].crear(nombreArtefacto);
			var div = document.createElement("div");
			div.innerHTML = artefacto;
			el.parentNode.replaceChild(div.firstChild, el);
		}
		el.className += " ex-moved";
	}).on("over", function(el, container) {
		container.className += " ex-over";
	}).on("out", function(el, container) {
		container.className = container.className.replace("ex-over", "");
	}).on("dragend", function(el, container) {
        updateTogetherJS( $("#contenidoDidacticoBody").html() );
        TogetherJS.reinitialize();
	}).on("shadow", function(el, container) {
        updateTogetherJS( $("#contenidoDidacticoBody").html() );
        TogetherJS.reinitialize();
	});
}

/**
 * Rellena los selectores de artefactos de todas las etapas MDO.
 * OJO: ESTA FUNCIÓN ES ÚNICAMENTE DE PRUEBA Y NO IRÁ EN PRODUCCIÓN.
 */
function populateArtefactos() {
	populate("VivenciaFactory", "#vivenciaPanelBody");
	populate("ConceptualizacionFactory", "#conceptualizacionPanelBody");
	populate("DocumentacionFactory", "#documentacionPanelBody");
	populate("AplicacionFactory", "#aplicacionPanelBody");
	populate("AmpliacionFactory", "#ampliacionPanelBody");
}

/**
 * Rellena el selector de artefactos MDO con la fábrica indicada.
 * 
 * @param {string} nombreFabrica El nombre de la fábrica MDO a utilzar.
 * @param {string} selector ID de jQuery del selector de artefactos
 */
function populate(nombreFabrica, selector) {
	var body = $(selector);
	var lista = MDOFactories[nombreFabrica].listaArtefactos();
	lista.forEach(function(e) {
		body.append(e);
	});
}