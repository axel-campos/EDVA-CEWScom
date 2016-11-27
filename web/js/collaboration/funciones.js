$(document).ready(function () {
	initWorkspace();
	
    $("#btnGuardar").click(function () {
        var listaArtefactos = MDOUtil.parseNodeList(document.querySelectorAll(".event"));

		var artefactos = {
			artefactos: {
				ruta: RUTA_PERSISTENCIA,
				lista: intercambiarListaPorPares(MDOUtil.getListaArtefactos(listaArtefactos))
			}
		};

		console.log(artefactos);
		$.post(APP_BASE + "/mdocontenido/GuardarProgreso", {
			artefactos: JSON.stringify(artefactos),
			titulo: TITULO,
			version: VERSION
		}, function (response) {
			if (response.estatus) {
				BootstrapDialog.show({
					title: "Progreso Guardado",
					message: response.message,
					type: BootstrapDialog.TYPE_SUCCESS,
					buttons: [{
						label: "Continuar Colaborando",
						icon: "glyphicon glyphicon-ok-circle",
						cssClass: "btn-success",
						action: function (dialog) {
							dialog.close();
						}
					}]
				});
			} else {
				BootstrapDialog.show({
					title: "Error al Guardar Progreso",
					message: response.message,
					type: BootstrapDialog.TYPE_DANGER,
					buttons: [{
						label: "Cerrar",
						icon: "glyphicon glyphicon-remove-circle",
						cssClass: "btn-danger",
						action: function (dialog) {
							dialog.close();
						}
					}]
				});
			}
		});
    });
});

/**
 * Intercambia los objetos de la lista de par en par. Por ejemplo, los
 * elementos de la lista [a, b, c, d, ...] quedarían ordenados
 * de la siguiente manera: [b, a, d, c, ...].
 * 
 * @param {array} lista La lista de elementos a intercambiar.
 * @returns {array} La lista intercambiada.
 */
function intercambiarListaPorPares(lista) {
	var length = lista.length;
	
	if (length === 0) {
		return [];
	} else if (length === 1) {
		return [lista[0]];
	} else if (length === 2) {
		return [lista[1], lista[0]];
	}
	
	var intercambiado = [];
	
	for (var i = 0; i < length; i += 2) {
		if ((i + 1) < length) {
			intercambiado.push(lista[i + 1]);
			intercambiado.push(lista[i]);
		}
	}
	
	return (length % 2 === 0) ? intercambiado : intercambiado.concat(lista[length - 1]);
}

/**
 * Recrea la línea del tiempo a partir de los artefactos obtenidos del servidor.
 * 
 * @param {array} artefactos Los artefactos recuperados del servidor.
 * @param {string} container El contenedor donde se insertarán los artefactos.
 */
function recrearTimeline(artefactos, container) {
    var body = intercambiarListaPorPares(MDOTimeline.obtenerNodos(artefactos)).join("");
	$(container).empty().html("<li class='year'>Inicio</li>").append(body);
}

/**
 * Agrega la funcionalidad de Drag and Drop al selector de artefactos MDO
 * y al área de trabajo de los contenidos didácticos.
 * 
 * @param {string} selector ID de jQuery del selector de artefactos
 * @param {type} nombreFabrica El nombre de la fábrica MDO a utilizar.
 */
function agregarDragAndDrop(selector, nombreFabrica) {
    var MDOArtifactsContainer = '#contenidoDidacticoBody';
    dragula([
        document.querySelector(selector),
        document.querySelector(MDOArtifactsContainer)
    ], {
        copy: function (el, source) {
            return source === document.querySelector(selector);
        },
        accepts: function (el, target) {
            return target !== document.querySelector(selector);
        },
        removeOnSpill: true
    }).on("drag", function (el) {
        el.className = el.className.replace("ex-moved", "").trim();
        updateTogetherJS(MDOArtifactsContainer);
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
        updateTogetherJS(MDOArtifactsContainer);
    }).on("out", function (el, container) {
        container.className = container.className.replace("ex-over", "").trim();
        updateTogetherJS(MDOArtifactsContainer);
    }).on("dragend", function (el, container) {
        updateTogetherJS(MDOArtifactsContainer);
    }).on("shadow", function (el, container) {
        updateTogetherJS(MDOArtifactsContainer);
    });
}

/**
 * Rellena el selector de artefactos MDO con la fábrica indicada.
 * 
 * @param {string} selector ID de jQuery del selector de artefactos
 * @param {string} nombreFabrica El nombre de la fábrica MDO a utilizar.
 */
function populate(selector, nombreFabrica) {
    var body = $(selector);
    var lista = MDOFactories[nombreFabrica].listaArtefactos();
    lista.forEach(function (e) {
        body.append(e);
    });
}

function initWorkspace() {
    var targetDiv = "#" + ETAPA + "PanelBody";
    var MDOfactory = ETAPA + "Factory";

    populate(targetDiv, MDOfactory);
    agregarDragAndDrop(targetDiv, MDOfactory);
}