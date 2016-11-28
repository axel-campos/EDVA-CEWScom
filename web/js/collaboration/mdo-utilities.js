var MDOUtil = (function() {
	var MDOParser = (function() {
		var _VivenciaParser = (function() {
			function ObservacionParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var pregunta = contenido[1].value;
				var fenomenoAObservar = contenido[2].value;
				var posibleExplicacion = contenido[3].value;
				var posibleResultado = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					pregunta: pregunta,
					fenomenoAObservar: fenomenoAObservar,
					posibleExplicacion: posibleExplicacion,
					posibleResultado: posibleResultado
				};
			}
			
			function VisitaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var lugarAVisitar = contenido[1].value;
				var tematica = contenido[2].value;
				var proposito = contenido[3].value;
				var objetivos = contenido[4].value;
				var entregables = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					lugarAVisitar: lugarAVisitar,
					tematica: tematica,
					proposito: proposito,
					objetivos: objetivos,
					entregables: entregables
				};
			}
			
			function DemostracionParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var objetivo = contenido[1].value;
				var materialNecesario = contenido[2].value;
				var procedimiento = contenido[3].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					objetivo: objetivo,
					materialNecesario: materialNecesario,
					procedimiento: procedimiento
				};
			}
			
			function EnsayoParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var requisitos = contenido[3].value;
				var tiempoRealizacion = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					requisitos: requisitos,
					tiempoRealizacion: tiempoRealizacion
				};
			}
			
			function SimulacionParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var tematica = contenido[1].value;
				var descripcion = contenido[2].value;
				var roles = contenido[3].value;
				var materialNecesario = contenido[4].value;
				var procedimiento = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					tematica: tematica,
					descripcion: descripcion,
					roles: roles,
					materialNecesario: materialNecesario,
					procedimiento: procedimiento
				};
			}
			
			/**
			 * Analiza el nodo DOM pasado y lo convierte a un objeto JavaScript
			 * apropiado de la etapa MDO de Vivencia.
			 * @param {string} nombreArtefacto El nombreArtefacto del artefacto.
			 * @param {Node} contenido El nodo DOM del artefacto.
			 * @param {string} id El ID del artefacto.
			 * @returns {Object} Un objeto que contiene la información ingresada
			 * sobre el artefacto.
			 */
			function _parse(nombreArtefacto, contenido, id) {
				if (nombreArtefacto.includes("observacion"))
					return ObservacionParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("visita"))
					return VisitaParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("demostracion"))
					return DemostracionParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("ensayo"))
					return EnsayoParser(nombreArtefacto, contenido, id);
				else
					return SimulacionParser(nombreArtefacto, contenido, id);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _ConceptualizacionParser = (function() {
			function PreguntasParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var preguntas = contenido[3].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					preguntas: preguntas
				};
			}
			
			function TutoriaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var objetivos = contenido[2].value;
				var temas = contenido[3].value;
				var materialApoyo = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					objetivos: objetivos,
					temas: temas,
					materialApoyo: materialApoyo
				};
			}
			
			function LluviaIdeasParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var problematica = contenido[3].value;
				var preguntasClave = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					problematica: problematica,
					preguntasClave: preguntasClave
				};
			}
			
			function GrupoEstudioParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var integrantes = contenido[3].value;
				var entregables = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					integrantes: integrantes,
					entregables: entregables
				};
			}
			
			/**
			 * Analiza el nodo DOM pasado y lo convierte a un objeto JavaScript
			 * apropiado de la etapa MDO de Conceptualización.
			 * @param {string} nombreArtefacto El nombreArtefacto del artefacto.
			 * @param {Node} contenido El nodo DOM del artefacto.
			 * @returns {Object} Un objeto que contiene la información ingresada
			 * @param {string} id El ID del artefacto.
			 * sobre el artefacto.
			 */
			function _parse(nombreArtefacto, contenido, id) {
				if (nombreArtefacto.includes("preguntas"))
					return PreguntasParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("tutoria"))
					return TutoriaParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("lluviaideas"))
					return LluviaIdeasParser(nombreArtefacto, contenido, id);
				else
					return GrupoEstudioParser(nombreArtefacto, contenido, id);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _DocumentacionParser = (function() {
			function PeliculaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var director = contenido[2].value;
				var productora = contenido[3].value;
				var pais = contenido[4].value;
				var anyo = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					director: director,
					productora: productora,
					pais: pais,
					anyo: anyo
				};
			}
			
			function VideoParser(nombreArtefacto, contenido, id) {
				var nombre = contenido[0].value;
				var descripcion = contenido[1].value;
				var url = contenido[2].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					nombre: nombre,
					descripcion: descripcion,
					url: url
				};
			}
			
			function LibroParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var autor = contenido[1].value;
				var anyo = contenido[2].value;
				var ciudad = contenido[3].value;
				var editorial = contenido[4].value;
				var volumen = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					autor: autor,
					titulo: titulo,
					anyo: anyo,
					ciudad: ciudad,
					editorial: editorial,
					volumen: volumen
				};
			}
			
			function ArticuloWebParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var autor = contenido[1].value;
				var descripcion = contenido[2].value;
				var nombreSitioWeb = contenido[3].value;
				var anyo = contenido[4].value;
				var mes = contenido[5].value;
				var dia = contenido[6].value;
				var url = contenido[7].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					autor: autor,
					titulo: titulo,
					descripcion: descripcion,
					nombreSitioWeb: nombreSitioWeb,
					anyo: anyo,
					mes: mes,
					dia: dia,
					url: url
				};
			}
			
			function ArticuloPDFParser(nombreArtefacto, contenido, id) {
				var nombre = contenido[0].value;
				var descripcion = contenido[1].value;
				var url = contenido[2].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					nombre: nombre,
					descripcion: descripcion,
					url: url
				};
			}
			
			function RevistaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var autor = contenido[1].value;
				var descripcion = contenido[2].value;
				var nombreRevista = contenido[3].value;
				var anyo = contenido[4].value;
				var paginas = contenido[5].value;
				var volumen = contenido[6].value;
				var numero = contenido[7].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					autor: autor,
					titulo: titulo,
					descripcion: descripcion,
					nombreRevista: nombreRevista,
					anyo: anyo,
					paginas: paginas,
					volumen: volumen,
					numero: numero
				};
			}
			
			/**
			 * Analiza el nodo DOM pasado y lo convierte a un objeto JavaScript
			 * apropiado de la etapa MDO de Documentación.
			 * @param {string} nombreArtefacto El nombreArtefacto del artefacto.
			 * @param {Node} contenido El nodo DOM del artefacto.
			 * @param {string} id El ID del artefacto.
			 * @returns {Object} Un objeto que contiene la información ingresada
			 * sobre el artefacto.
			 */
			function _parse(nombreArtefacto, contenido, id) {
				if (nombreArtefacto.includes("pelicula"))
					return PeliculaParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("video"))
					return VideoParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("libro"))
					return LibroParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("articuloweb"))
					return ArticuloWebParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("articulopdf"))
					return ArticuloPDFParser(nombreArtefacto, contenido, id);
				else
					return RevistaParser(nombreArtefacto, contenido, id);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _AplicacionParser = (function() {
			function EstudioCasoParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var objetivos = contenido[2].value;
				var problematica = contenido[3].value;
				var metodosInvestigacion = contenido[4].value;
				var entregables = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					objetivos: objetivos,
					problematica: problematica,
					metodosInvestigacion: metodosInvestigacion,
					entregables: entregables
				};
			}
			
			function MarcoLogicoParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var objetivoGeneral = contenido[1].value;
				var objetivosEspecificos = contenido[2].value;
				var resultados = contenido[3].value;
				var actividades = contenido[4].value;
				var indicadores = contenido[5].value;
				var fuentesVerificacion = contenido[6].value;
				var supuestos = contenido[7].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					objetivoGeneral: objetivoGeneral,
					objetivosEspecificos: objetivosEspecificos,
					resultados: resultados,
					actividades: actividades,
					indicadores: indicadores,
					fuentesVerificacion: fuentesVerificacion,
					supuestos: supuestos
				};
			}
			
			function MapaConceptualParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var entregables = contenido[3].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					entregables: entregables
				};
			}
			
			function ArbolProblemasParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var problematicaCentral = contenido[2].value;
				var causas = contenido[3].value;
				var problemasSecundarios = contenido[4].value;
				var efectos = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					problematicaCentral: problematicaCentral,
					causas: causas,
					problemasSecundarios: problemasSecundarios,
					efectos: efectos
				};
			}
			
			function ProyectoInvestigacionParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var objetivos = contenido[2].value;
				var marcoTeorico = contenido[3].value;
				var hipotesis = contenido[4].value;
				var entregables = contenido[5].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					objetivos: objetivos,
					marcoTeorico: marcoTeorico,
					hipotesis: hipotesis,
					entregables: entregables
				};
			}
			
			function EjerciciosParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var ejercicios = contenido[3].value;
				var entregables = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					ejercicios: ejercicios,
					entregables: entregables
				};
			}
			
			/**
			 * Analiza el nodo DOM pasado y lo convierte a un objeto JavaScript
			 * apropiado de la etapa MDO de Aplicación.
			 * @param {string} nombreArtefacto El nombreArtefacto del artefacto.
			 * @param {Node} contenido El nodo DOM del artefacto.
			 * @param {string} id El ID del artefacto.
			 * @returns {Object} Un objeto que contiene la información ingresada
			 * sobre el artefacto.
			 */
			function _parse(nombreArtefacto, contenido, id) {
				if (nombreArtefacto.includes("estudiocaso"))
					return EstudioCasoParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("marcologico"))
					return MarcoLogicoParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("mapaconceptual"))
					return MapaConceptualParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("arbolproblemas"))
					return ArbolProblemasParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("proyectoinvestigacion"))
					return ProyectoInvestigacionParser(nombreArtefacto, contenido, id);
				else
					return EjerciciosParser(nombreArtefacto, contenido, id);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _AmpliacionParser = (function() {
			function ConferenciaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var objetivos = contenido[2].value;
				var tematica = contenido[3].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					objetivos: objetivos,
					tematica: tematica
				};
			}
			
			function MesaRedondaParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var numeroIntegrantes = contenido[3].value;
				var tiempoExposicion = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					numeroIntegrantes: numeroIntegrantes,
					tiempoExposicion: tiempoExposicion
				};
			}
			
			function PanelParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var numeroIntegrantes = contenido[3].value;
				var tiempoExposicion = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					numeroIntegrantes: numeroIntegrantes,
					tiempoExposicion: tiempoExposicion
				};
			}
			
			function SimposioParser(nombreArtefacto, contenido, id) {
				var titulo = contenido[0].value;
				var descripcion = contenido[1].value;
				var tematica = contenido[2].value;
				var numeroIntegrantes = contenido[3].value;
				var tiempoExposicionPorIntegrante = contenido[4].value;
				
				return {
					artefacto: nombreArtefacto,
					id: id,
					titulo: titulo,
					descripcion: descripcion,
					tematica: tematica,
					numeroIntegrantes: numeroIntegrantes,
					tiempoExposicionPorIntegrante: tiempoExposicionPorIntegrante
				};
			}
			
			/**
			 * Analiza el nodo DOM pasado y lo convierte a un objeto JavaScript
			 * apropiado de la etapa MDO de Ampliación.
			 * @param {string} nombreArtefacto El nombreArtefacto del artefacto.
			 * @param {Node} contenido El nodo DOM del artefacto.
			 * @param {string} id El ID del artefacto.
			 * @returns {Object} Un objeto que contiene la información ingresada
			 * sobre el artefacto.
			 */
			function _parse(nombreArtefacto, contenido, id) {
				if (nombreArtefacto.includes("conferencia"))
					return ConferenciaParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("mesaredonda"))
					return MesaRedondaParser(nombreArtefacto, contenido, id);
				else if (nombreArtefacto.includes("ampliacion-panel"))
					return PanelParser(nombreArtefacto, contenido, id);
				else
					return SimposioParser(nombreArtefacto, contenido, id);
			}
			
			return {
				parse: _parse
			};
		})();
		
		return {
			VivenciaParser: _VivenciaParser,
			ConceptualizacionParser: _ConceptualizacionParser,
			DocumentacionParser: _DocumentacionParser,
			AplicacionParser: _AplicacionParser,
			AmpliacionParser: _AmpliacionParser
		};
	})();
	
	/**
	 * Toma una lista del tipo NodeList y regresa un Array común de JavaScript.
	 * Se utiliza para convertir la NodeList de artefactos MDO en un arreglo de nodos
	 * fácil de manipular.
	 * 
	 * @param {NodeList} nodeList Una lista de artefactos, obtenidos preferentemente
	 * por document.querySelectorAll('.event').
	 * @returns {Array} Un arreglo común con los nodos de los artefactos MDO.
	 */
	function _parseNodeList(nodeList) {
		return [].slice.call(nodeList);
	}
	
	/**
	 * Obtiene un nodo DOM de algún artefacto MDO y regresa un objeto equivalente. El
	 * nodo debe ser de la clase .mdo-[etapa]-[artefacto]
	 * @param {Node} node Un objeto DOM Node.
	 * @returns {Object} Un objeto con los atributos del artefacto utilizado.
	 */
	function _parseNode(node) {
		var nombreArtefacto = node.className.split(" ")[0];
		var contenido = $(node).children("div").children("input");
		var id = $(node).children("div")[0].id;
		var tipoParser;
		
		if (nombreArtefacto.includes("vivencia"))
			tipoParser = "VivenciaParser";
		else if (nombreArtefacto.includes("conceptualizacion"))
			tipoParser = "ConceptualizacionParser";
		else if (nombreArtefacto.includes("documentacion"))
			tipoParser = "DocumentacionParser";
		else if (nombreArtefacto.includes("aplicacion"))
			tipoParser = "AplicacionParser";
		else
			tipoParser = "AmpliacionParser";
		
		return MDOParser[tipoParser].parse(nombreArtefacto, contenido, id);
	}
	
	/**
	 * Convierte una lista de nodos DOM en una lista de objetos JavaScript. Los nodos
	 * deben ser de la clase .mdo-[etapa]-[artefacto]
	 * 
	 * @param {Array} nodeArray Un arreglo JavaScript de objetos DOM Node.
	 * @returns {Object} Una lista de objetos-artefacto.
	 */
	function _getListaArtefactos(nodeArray) {
		return nodeArray.map(function(e) {
			return _parseNode(e);
		});
	}
	
	return {
		parseNodeList: _parseNodeList,
		getListaArtefactos: _getListaArtefactos
	};
})();

var MDOTimeline = (function() {
	var MDOParser = (function() {
		var _VivenciaParser = (function() {
			function ObservacionParser(contenido) {
				return "<li class='mdo-vivencia-observacion event'>\n\
							<h2 class='heading'>\n\
								<a data-toggle='collapse' href='#" + contenido.id + "'>Observación</a>\n\
								<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
									<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
								</button>\n\
							</h2>\n\
							<div id='" + contenido.id + "' class='collapse'>\n\
								<label>Título:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
								<label>Pregunta:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.pregunta + "' /><br>\n\
								<label>Fenómeno a observar:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.fenomenoAObservar + "' /><br>\n\
								<label>Posible explicación:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.posibleExplicacion + "' /><br>\n\
								<label>Posible resultado:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.posibleResultado + "' />\n\
							</div>\n\
						</li>";
			}
			
			function VisitaParser(contenido) {
				return "<li class='mdo-vivencia-visita event'>\n\
							<h2 class='heading'>\n\
								<a data-toggle='collapse' href='#" + contenido.id + "'>Visita</a>\n\
								<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
									<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
								</button>\n\
							</h2>\n\
							<div id='" + contenido.id + "' class='collapse'>\n\
								<label>Título:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
								<label>Lugar a visitar:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.lugarAVisitar + "' /><br>\n\
								<label>Temática del lugar:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
								<label>Propósito:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.proposito + "' /><br>\n\
								<label>Objetivos:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.objetivos + "' /><br>\n\
								<label>Entregables:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' />\n\
							</div>\n\
						</li>";
			}
			
			function DemostracionParser(contenido) {
				return "<li class='mdo-vivencia-demostracion event'>\n\
							<h2 class='heading'>\n\
								<a data-toggle='collapse' href='#" + contenido.id + "'>Demostración</a>\n\
								<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
									<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
								</button>\n\
							</h2>\n\
							<div id='" + contenido.id + "' class='collapse'>\n\
								<label>Título:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
								<label>Objetivo:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.objetivo + "' /><br>\n\
								<label>Material necesario:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.materialNecesario + "' /><br>\n\
								<label>Procedimiento:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.procedimiento + "' />\n\
							</div>\n\
						</li>";
			}
			
			function EnsayoParser(contenido) {
				return "<li class='mdo-vivencia-ensayo event'>\n\
							<h2 class='heading'>\n\
								<a data-toggle='collapse' href='#" + contenido.id + "'>Ensayo</a>\n\
								<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
									<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
								</button>\n\
							</h2>\n\
							<div id='" + contenido.id + "' class='collapse'>\n\
								<label>Título:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
								<label>Descripción:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
								<label>Temática:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
								<label>Requisitos:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.requisitos + "' /><br>\n\
								<label>Tiempo de realización:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.tiempoRealizacion + "' />\n\
							</div>\n\
						</li>";
			}
			
			function SimulacionParser(contenido) {
				return "<li class='mdo-vivencia-simulacion event'>\n\
							<h2 class='heading'>\n\
								<a data-toggle='collapse' href='#" + contenido.id + "'>Simulación</a>\n\
								<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
									<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
								</button>\n\
							</h2>\n\
							<div id='" + contenido.id + "' class='collapse'>\n\
								<label>Título:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
								<label>Temática:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
								<label>Descripción:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
								<label>Roles:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.roles + "' /><br>\n\
								<label>Material necesario:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.materialNecesario + "' /><br>\n\
								<label>Procedimiento:</label>\n\
								<input type='text' class='form-control input-sm' value='" + contenido.procedimiento + "' />\n\
							</div>\n\
						</li>";
			}
			
			/**
			 * Analiza el artefacto pasado y lo convierte a una cadena HTML
			 * apropiado de la etapa MDO de Vivencia.
			 * @param {string} nombreArtefacto El nombre del artefacto.
			 * @param {object} contenido El artefacto como objeto JavaScript.
			 * @returns {string} Una cadena con la información del artefacto.
			 */
			function _parse(nombreArtefacto, contenido) {
				if (nombreArtefacto.includes("observacion"))
					return ObservacionParser(contenido);
				else if (nombreArtefacto.includes("visita"))
					return VisitaParser(contenido);
				else if (nombreArtefacto.includes("demostracion"))
					return DemostracionParser(contenido);
				else if (nombreArtefacto.includes("ensayo"))
					return EnsayoParser(contenido);
				else
					return SimulacionParser(contenido);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _ConceptualizacionParser = (function() {
			function PreguntasParser(contenido) {
				return "<li class='mdo-conceptualizacion-preguntas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Preguntas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Preguntas a realizar:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.preguntas + "' />\n\
						</div>\n\
					</li>";
			}
			
			function TutoriaParser(contenido) {
				return "<li class='mdo-conceptualizacion-tutoria event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Tutoría</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivos + "' /><br>\n\
							<label>Temas a tratar:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.temas + "' /><br>\n\
							<label>Material de apoyo:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.materialApoyo + "' />\n\
						</div>\n\
					</li>";
			}
			
			function LluviaIdeasParser(contenido) {
				return "<li class='mdo-conceptualizacion-lluviaideas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Lluvia de Ideas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Problemática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.problematica + "' /><br>\n\
							<label>Preguntas clave:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.preguntasClave + "' />\n\
						</div>\n\
					</li>";
			}
			
			function GrupoEstudioParser(contenido) {
				return "<li class='mdo-conceptualizacion-grupoestudio event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Grupo de Estudio</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Integrantes por grupo:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.integrantes + "' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' /><br>\n\
						</div>\n\
					</li>";
			}
			
			/**
			 * Analiza el artefacto pasado y lo convierte a una cadena HTML
			 * apropiado de la etapa MDO de Conceptualización.
			 * @param {string} nombreArtefacto El nombre del artefacto.
			 * @param {object} contenido El artefacto como objeto JavaScript.
			 * @returns {string} Una cadena con la información del artefacto.
			 */
			function _parse(nombreArtefacto, contenido) {
				if (nombreArtefacto.includes("preguntas"))
					return PreguntasParser(contenido);
				else if (nombreArtefacto.includes("tutoria"))
					return TutoriaParser(contenido);
				else if (nombreArtefacto.includes("lluviaideas"))
					return LluviaIdeasParser(contenido);
				else
					return GrupoEstudioParser(contenido);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _DocumentacionParser = (function() {
			function PeliculaParser(contenido) {
				return "<li class='mdo-documentacion-pelicula event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Película</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Director:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.director + "' /><br>\n\
							<label>Productora:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.productora + "' /><br>\n\
							<label>País o región:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.pais + "' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.anyo + "' />\n\
						</div>\n\
					</li>";
			}
			
			function VideoParser(contenido) {
				return "<li class='mdo-documentacion-video event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Video</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Nombre:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.nombre + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>URL del video:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.url + "' />\n\
						</div>\n\
					</li>";
			}
			
			function LibroParser(contenido) {
				return "<li class='mdo-documentacion-libro event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Libro</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.autor + "' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.anyo + "' /><br>\n\
							<label>Ciudad:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.ciudad + "' /><br>\n\
							<label>Editorial:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.editorial + "' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.volumen + "' />\n\
						</div>\n\
					</li>";
			}
			
			function ArticuloWebParser(contenido) {
				return "<li class='mdo-documentacion-articuloweb event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Artículo Web</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.autor + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Nombre del sitio Web:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.nombreSitioWeb + "' /><br>\n\
							<label>Año en que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.anyo + "' /><br>\n\
							<label>Mes en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.mes + "' /><br>\n\
							<label>Día en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.dia + "' /><br>\n\
							<label>URL:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.url + "' />\n\
						</div>\n\
					</li>";
			}
			
			function ArticuloPDFParser(contenido) {
				return "<li class='mdo-documentacion-articulopdf event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Artículo PDF</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Nombre:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.nombre + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>URL del artículo:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.url + "' />\n\
						</div>\n\
					</li>";
			}
			
			function RevistaParser(contenido) {
				return "<li class='mdo-documentacion-revista event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Revista</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.autor + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Nombre de la revista:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.nombreRevista + "' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.anyo + "' /><br>\n\
							<label>Páginas:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.paginas + "' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.volumen + "' /><br>\n\
							<label>Número:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.numero + "' />\n\
						</div>\n\
					</li>";
			}
			
			/**
			 * Analiza el artefacto pasado y lo convierte a una cadena HTML
			 * apropiado de la etapa MDO de Documentación.
			 * @param {string} nombreArtefacto El nombre del artefacto.
			 * @param {object} contenido El artefacto como objeto JavaScript.
			 * @returns {string} Una cadena con la información del artefacto.
			 */
			function _parse(nombreArtefacto, contenido) {
				if (nombreArtefacto.includes("pelicula"))
					return PeliculaParser(contenido);
				else if (nombreArtefacto.includes("video"))
					return VideoParser(contenido);
				else if (nombreArtefacto.includes("libro"))
					return LibroParser(contenido);
				else if (nombreArtefacto.includes("articuloweb"))
					return ArticuloWebParser(contenido);
				else if (nombreArtefacto.includes("articulopdf"))
					return ArticuloPDFParser(contenido);
				else
					return RevistaParser(contenido);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _AplicacionParser = (function() {
			function EstudioCasoParser(contenido) {
				return "<li class='mdo-aplicacion-estudiocaso event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Estudio de Caso</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivos + "' /><br>\n\
							<label>Problemática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.problematica + "' /><br>\n\
							<label>Métodos de investigación:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.metodosInvestigacion + "' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' />\n\
						</div>\n\
					</li>";
			}
			
			function MarcoLogicoParser(contenido) {
				return "<li class='mdo-aplicacion-marcologico event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Marco Lógico</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Objetivo general:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivoGeneral + "' /><br>\n\
							<label>Objetivos específicos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivosEspecificos + "' /><br>\n\
							<label>Resultados esperados:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.resultados + "' /><br>\n\
							<label>Actividades a realizar:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.actividades + "' /><br>\n\
							<label>Indicadores:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.indicadores + "' /><br>\n\
							<label>Fuentes de verificación:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.fuentesVerificacion + "' /><br>\n\
							<label>Supuestos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.supuestos + "' />\n\
						</div>\n\
					</li>";
			}
			
			function MapaConceptualParser(contenido) {
				return "<li class='mdo-aplicacion-mapaconceptual event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Mapa Conceptual</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' />\n\
						</div>\n\
					</li>";
			}
			
			function ArbolProblemasParser(contenido) {
				return "<li class='mdo-aplicacion-arbolproblemas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Árbol de Problemas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Problemática principal:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.problematicaCentral + "' /><br>\n\
							<label>Causas:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.causas + "' /><br>\n\
							<label>Problemas secundarios:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.problemasSecundarios + "' /><br>\n\
							<label>Efectos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.efectos + "' />\n\
						</div>\n\
					</li>";
			}
			
			function ProyectoInvestigacionParser(contenido) {
				return "<li class='mdo-aplicacion-proyectoinvestigacion event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Proyecto de Investigación</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivos + "' /><br>\n\
							<label>Marco teórico:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.marcoTeorico + "' /><br>\n\
							<label>Hipótesis:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.hipotesis + "' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' />\n\
						</div>\n\
					</li>";
			}
			
			function EjerciciosParser(contenido) {
				return "<li class='mdo-aplicacion-ejercicios event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Ejercicios</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Ejercicios:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.ejercicios + "' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.entregables + "' />\n\
						</div>\n\
					</li>";
			}
			
			/**
			 * Analiza el artefacto pasado y lo convierte a una cadena HTML
			 * apropiado de la etapa MDO de Aplicación.
			 * @param {string} nombreArtefacto El nombre del artefacto.
			 * @param {object} contenido El artefacto como objeto JavaScript.
			 * @returns {string} Una cadena con la información del artefacto.
			 */
			function _parse(nombreArtefacto, contenido) {
				if (nombreArtefacto.includes("estudiocaso"))
					return EstudioCasoParser(contenido);
				else if (nombreArtefacto.includes("marcologico"))
					return MarcoLogicoParser(contenido);
				else if (nombreArtefacto.includes("mapaconceptual"))
					return MapaConceptualParser(contenido);
				else if (nombreArtefacto.includes("arbolproblemas"))
					return ArbolProblemasParser(contenido);
				else if (nombreArtefacto.includes("proyectoinvestigacion"))
					return ProyectoInvestigacionParser(contenido);
				else
					return EjerciciosParser(contenido);
			}
			
			return {
				parse: _parse
			};
		})();
		
		var _AmpliacionParser = (function() {
			function ConferenciaParser(contenido) {
				return "<li class='mdo-ampliacion-conferencia event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Conferencia</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.objetivos + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' />\n\
						</div>\n\
					</li>";
			}
			
			function MesaRedondaParser(contenido) {
				return "<li class='mdo-ampliacion-mesaredonda event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Mesa Redonda</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.numeroIntegrantes + "' /><br>\n\
							<label>Tiempo de exposición:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tiempoExposicion + "' />\n\
						</div>\n\
					</li>";
			}
			
			function PanelParser(contenido) {
				return "<li class='mdo-ampliacion-panel event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Panel</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.numeroIntegrantes + "' /><br>\n\
							<label>Tiempo de exposición:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tiempoExposicion + "' />\n\
						</div>\n\
					</li>";
			}
			
			function SimposioParser(contenido) {
				return "<li class='mdo-ampliacion-simposio event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + contenido.id + "'>Simposio</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + contenido.id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.titulo + "' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.descripcion + "' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tematica + "' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.numeroIntegrantes + "' /><br>\n\
							<label>Tiempo de exposición por integrante:</label>\n\
							<input type='text' class='form-control input-sm' value='" + contenido.tiempoExposicionPorIntegrante + "' />\n\
						</div>\n\
					</li>";
			}
			
			/**
			 * Analiza el artefacto pasado y lo convierte a una cadena HTML
			 * apropiado de la etapa MDO de Ampliación.
			 * @param {string} nombreArtefacto El nombre del artefacto.
			 * @param {object} contenido El artefacto como objeto JavaScript.
			 * @returns {string} Una cadena con la información del artefacto.
			 */
			function _parse(nombreArtefacto, contenido) {
				if (nombreArtefacto.includes("conferencia"))
					return ConferenciaParser(contenido);
				else if (nombreArtefacto.includes("mesaredonda"))
					return MesaRedondaParser(contenido);
				else if (nombreArtefacto.includes("ampliacion-panel"))
					return PanelParser(contenido);
				else
					return SimposioParser(contenido);
			}
			
			return {
				parse: _parse
			};
		})();
		
		return {
			VivenciaParser: _VivenciaParser,
			ConceptualizacionParser: _ConceptualizacionParser,
			DocumentacionParser: _DocumentacionParser,
			AplicacionParser: _AplicacionParser,
			AmpliacionParser: _AmpliacionParser
		};
	})();
	
	/**
	 * Convierte un objeto JavaScript en su equivalente HTML, de acuerdo
	 * a su etapa.
	 * 
	 * @param {object} artefacto El artefacto
	 * @returns {string} Una cadena HTML con la información del artefacto.
	 */
	function _parseNode(artefacto) {
		var nombreArtefacto = artefacto.artefacto;
		var tipoParser;
		
		if (nombreArtefacto.includes("vivencia"))
			tipoParser = "VivenciaParser";
		else if (nombreArtefacto.includes("conceptualizacion"))
			tipoParser = "ConceptualizacionParser";
		else if (nombreArtefacto.includes("documentacion"))
			tipoParser = "DocumentacionParser";
		else if (nombreArtefacto.includes("aplicacion"))
			tipoParser = "AplicacionParser";
		else
			tipoParser = "AmpliacionParser";
		
		return MDOParser[tipoParser].parse(nombreArtefacto, artefacto);
	}
	
	/**
	 * Convierte los artefactos dados en nodos HTML
	 * que puedan insertarse directamente en el timeline.
	 * 
	 * @param {array} artefactos Un arreglo de objetos JavaScript,
	 * donde cada uno contiene un artefacto de la etapa.
	 * @returns {array} Un arreglo de nodos HTML, cada uno 
	 * contiene la información.
	 */
	function _obtenerNodos(artefactos) {
		return artefactos.map(function(e) {
			return _parseNode(e);
		});
	}
	
	return {
		parseNode: _parseNode,
		obtenerNodos: _obtenerNodos
	};
})();