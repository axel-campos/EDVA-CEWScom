$(document).ready(function () {    
    var targetDiv = "#" + ETAPA + "PanelBody";
    var MDOfactory = ETAPA + "Factory";

    console.log(targetDiv + "::" + MDOfactory);
    
    populate(targetDiv, MDOfactory);
    agregarDragAndDrop(targetDiv, MDOfactory);
	recrearTimeline(MDOfactory, ARTEFACTOS);

    $("#btnGuardar").click(function () {
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

    $("#btnDescargar").click(function () {
        $.post(APP_BASE + "/mdocontenido/DescargarContenido", {}, function (response) {
            alert(response.stateMap.message);
        });
    });
});

/**
 * Recrea la línea del tiempo a partir de los artefactos obtenidos del servidor.
 * 
 * @param {string} factory El nombre de la fábrica abstracta a utilizar.
 * @param {object} artefactos Los artefactos recuperados del servidor.
 */
function recrearTimeline(factory, artefactos) {
	var body = "<li class='year'>" + ETAPA + "</li>";
		
	if (ETAPA === "Vivencias") {
		body += MDOFactories[factory].crear("Observacion")
			+ MDOFactories[factory].crear("Visita")
			+ MDOFactories[factory].crear("Demostracion")
			+ MDOFactories[factory].crear("Ensayo")
			+ MDOFactories[factory].crear("Simulacion")
			+ MDOFactories[factory].crear("JuegoRol");
	} else if (ETAPA === "Conceptualizacón") {
		body += MDOFactories[factory].crear("Dinamica")
			+ MDOFactories[factory].crear("Preguntas")
			+ MDOFactories[factory].crear("Tutoria")
			+ MDOFactories[factory].crear("LluviaIdeas")
			+ MDOFactories[factory].crear("GrupoEstudio");
	} else if (ETAPA === "Documentación") {
		body += MDOFactories[factory].crear("Pelicula")
			+ MDOFactories[factory].crear("Video")
			+ MDOFactories[factory].crear("Libro")
			+ MDOFactories[factory].crear("ArticuloWeb")
			+ MDOFactories[factory].crear("ArticuloPDF")
			+ MDOFactories[factory].crear("Revista");
	} else if (ETAPA === "Aplicación") {
		body += MDOFactories[factory].crear("EstudioCasos")
			+ MDOFactories[factory].crear("MarcoLogico")
			+ MDOFactories[factory].crear("MapaConceptual")
			+ MDOFactories[factory].crear("ArbolProblemas")
			+ MDOFactories[factory].crear("ProyectoInvestigacion")
			+ MDOFactories[factory].crear("ProyectoProduccion")
			+ MDOFactories[factory].crear("Ejercicios");
	} else {
		body += MDOFactories[factory].crear("Conferencia")
			+ MDOFactories[factory].crear("MesaRedonda")
			+ MDOFactories[factory].crear("Panel")
			+ MDOFactories[factory].crear("Simposio")
	}
	
	
	$("#contenidoDidacticoBody").html(body);
}

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
        copy: function (el, source) {
            return source === document.querySelector(selector);
        },
        accepts: function (el, target) {
            return target !== document.querySelector(selector);
        },
        removeOnSpill: true
    }).on("drag", function (el) {
        el.className = el.className.replace("ex-moved", "");
        updateTogetherJS("#contenidoDidacticoBody");
    }).on("drop", function (el) {
        var nombreArtefacto = el.className.replace("gu-transit", "").trim();
        if (!el.className.includes("mdo-")) {
            var artefacto = MDOFactories[nombreFabrica].crear(nombreArtefacto);
            var div = document.createElement("div");
            div.innerHTML = artefacto;
            el.parentNode.replaceChild(div.firstChild, el);
        }
        el.className += " ex-moved";
    }).on("over", function (el, container) {
        container.className += " ex-over";
        updateTogetherJS("#contenidoDidacticoBody");
    }).on("out", function (el, container) {
        container.className = container.className.replace("ex-over", "");
        updateTogetherJS("#contenidoDidacticoBody");
    }).on("dragend", function (el, container) {
        updateTogetherJS("#contenidoDidacticoBody");
    }).on("shadow", function (el, container) {
        updateTogetherJS("#contenidoDidacticoBody");
    });
}

/**
 * Rellena los selectores de artefactos de todas las etapas MDO.
 * OJO: ESTA FUNCIÓN ES ÚNICAMENTE DE PRUEBA Y NO IRÁ EN PRODUCCIÓN.
 */
function populateArtefactos() {
    populate("VivenciasFactory", "#VivenciasPanelBody");
    populate("ConceptualizacionFactory", "#conceptualizacionPanelBody");
    populate("DocumentacionFactory", "#documentacionPanelBody");
    populate("AplicacionFactory", "#aplicacionPanelBody");
    populate("AmpliacionFactory", "#ampliacionPanelBody");
}

/**
 * Rellena el selector de artefactos MDO con la fábrica indicada.
 * 
 * @param {string} selector ID de jQuery del selector de artefactos
 * @param {string} nombreFabrica El nombre de la fábrica MDO a utilizar.
 */
function populate(selector , nombreFabrica) {
    var body = $(selector);
    var lista = MDOFactories[nombreFabrica].listaArtefactos();
    lista.forEach(function (e) {
        body.append(e);
    });
}
