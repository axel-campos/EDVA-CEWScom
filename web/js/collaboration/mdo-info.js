var MDOInfo = (function() {
	function Observacion() {
		return {
			title: "Artefacto <i>Observación</i>",
			message: "La <b>observación</b> es la técnica de adquisición de información de una fuente primaria."
				+ " Las observaciones pueden ser cualitativas (solo se registra la ausencia o presencia de una propiedad)"
				+ " o cuantitativas (si se asigna un valor numérico al fenómeno observado).<br><br>"
				+ "Este artefacto consiste de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la observación.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la observación.<br>"
				+ "<b class='text-success'>Fenómeno a observar:</b> El fenómeno natural a ser investigado.<br>"
				+ "<b class='text-success'>Pregunta:</b> Aquélla que dio origen a la observación.<br>"
				+ "<b class='text-success'>Posible explicación:</b> Hipótesis sobre la ocurrencia del fenómeno.<br>"
				+ "<b class='text-success'>Posible resultado:</b> Respuesta formulada con base en la hipótesis inicial."
		};
	}
	
	function Visita() {
		return {
			title: "Artefacto <i>Visita</i>",
			message: "La <b>visita</b> consiste en conducir a un grupo de personas por todas las áreas de servicio de"
				+ "algún lugar de interés, explicando de manera sencilla y amena qué es lo que hay en ella, buscando"
				+ " despertar la curiosidad y el deseo de aprender más de los visitantes.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la visita.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la visita.<br>"
				+ "<b class='text-success'>Lugar a visitar:</b> El punto de interés a visitar.<br>"
				+ "<b class='text-success'>Temática del lugar:</b> El ambiente del punto de interés (ciencias naturales, tecnología, ...)<br>"
				+ "<b class='text-success'>Propósito:</b> La razón por la cual se realizará la visita.<br>"
				+ "<b class='text-success'>Objetivos:</b> Los objetivos específicos a cumplir durante la visita.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos que se entregarán durante y al final de la visita."
		};
	}
	
	function Demostracion() {
		return {
			title: "Artefacto <i>Demostración</i>",
			message: "La <b>Demostración</b> es el razonamiento o prueba utilizado para comprobar la veracidad de alguna aseveración por medio"
				+ " de un experimento. La demostración puede utilizarse para poner en práctica las teorías aprendidas en clase.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la demostración.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la demostración.<br>"
				+ "<b class='text-success'>Objetivo:</b> El objetivo general de la demostración.<br>"
				+ "<b class='text-success'>Material necesario:</b> Los materiales requeridos para llevar a cabo la demostración.<br>"
				+ "<b class='text-success'>Procedimiento:</b> Los pasos a seguir de la demostración."
		};
	}
	
	function Ensayo() {
		return {
			title: "Artefacto <i>Ensayo</i>",
			message: "El <b>Ensayo</b> es un escrito en el cual el autor desarrolla sus opiniones y/o ideas sin tener que preocuparse por"
				+ " seguir una estructura rígida de redacción o documentarlo exhaustivamente.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del ensayo.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del ensayo a redactar.<br>"
				+ "<b class='text-success'>Temática:</b> El tema a tratar en el ensayo.<br>"
				+ "<b class='text-success'>Requisitos:</b> Los subtemas a tratar en el ensayo.<br>"
				+ "<b class='text-success'>Tiempo de realización:</b> El tiempo necesario para redactar el ensayo."
		};
	}
	
	function Simulacion() {
		return {
			title: "Artefacto <i>Simulación</i>",
			message: "La <b>simulación</b> es el acto de imitar la operación de un proceso o sistema del mundo real sobre un determinado tiempo."
				+ " El acto de simular algo requiere primero de la construcción de un modelo (el sistema en sí), el cual se ejecutará conforme"
				+ " pase el tiempo (la simulaciónn misma).<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la simulación.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la simulación.<br>"
				+ "<b class='text-success'>Temática:</b> El tema a tratar durante la simulación.<br>"
				+ "<b class='text-success'>Roles:</b> Los roles que se tomarán para la simulación.<br>"
				+ "<b class='text-success'>Material necesario:</b> Los materiales necesarios para llevar a cabo la simulación.<br>"
				+ "<b class='text-success'>Procedimiento:</b> Los pasos a seguir de la simulación."
		};
	}
	
	function Preguntas() {
		return {
			title: "Artefacto <i>Preguntas</i>",
			message: "Las <b>preguntas</b> forman la base de la investigación científica y pueden ser consideradas una transición entre las"
				+ " etapas de observación e hipótesis.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la serie de preguntas."
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de las preguntas a realizar.<br>"
				+ "<b class='text-success'>Temática:</b> La temática sobre la cual se realizarán las preguntas.<br>"
				+ "<b class='text-success'>Preguntas a realizar:</b> Las preguntas en sí."
		};
	}
	
	function Tutoria() {
		return {
			title: "Artefacto <i>Tutoría</i>",
			message: ""
		};
	}
	
	function LluviaIdeas() {
		return {
			title: "Artefacto <i>Lluvia de Ideas</i>",
			message: ""
		};
	}
	
	function GrupoEstudio() {
		return {
			title: "Artefacto <i>Grupo de Estudio</i>",
			message: ""
		};
	}
	
	function Pelicula() {
		return {
			title: "Artefacto <i>Película</i>",
			message: ""
		};
	}
	
	function Video() {
		return {
			title: "Artefacto <i>Video</i>",
			message: ""
		};
	}
	
	function Libro() {
		return {
			title: "Artefacto <i>Libro</i>",
			message: ""
		};
	}
	
	function ArticuloWeb() {
		return {
			title: "Artefacto <i>Artículo Web</i>",
			message: ""
		};
	}
	
	function ArticuloPDF() {
		return {
			title: "Artefacto <i>Artículo PDF</i>",
			message: ""
		};
	}
	
	function Revista() {
		return {
			title: "Artefacto <i>Revista</i>",
			message: ""
		};
	}
	
	function EstudioCaso() {
		return {
			title: "Artefacto <i>Estudio de Caso</i>",
			message: ""
		};
	}
	
	function MarcoLogico() {
		return {
			title: "Artefacto <i>Marco Lógico</i>",
			message: ""
		};
	}
	
	function MapaConceptual() {
		return {
			title: "Artefacto <i>Mapa Conceptual</i>",
			message: ""
		};
	}
	
	function ArbolProblemas() {
		return {
			title: "Artefacto <i>Árbol de Problemas</i>",
			message: ""
		};
	}
	
	function ProyectoInvestigacion() {
		return {
			title: "Artefacto <i>Proyecto de Investigación</i>",
			message: ""
		};
	}
	
	function Ejercicios() {
		return {
			title: "Artefacto <i>Ejercicios</i>",
			message: ""
		};
	}
	
	function Conferencia() {
		return {
			title: "Artefacto <i>Conferencia</i>",
			message: ""
		};
	}
	
	function MesaRedonda() {
		return {
			title: "Artefacto <i>Mesa Redonda</i>",
			message: ""
		};
	}
	
	function Panel() {
		return {
			title: "Artefacto <i>Panel</i>",
			message: ""
		};
	}
	
	function Simposio() {
		return {
			title: "Artefacto <i>Simposio</i>",
			message: ""
		};
	}
	
	/**
	 * Muestra un cuadro de diálogo con información
	 * específica del artefacto requerido.
	 * 
	 * @param {string} artefacto El nombre del artefacto.
	 */
	function _mostrarInfoArtefacto(artefacto) {
		var info;
		
		if (artefacto === "Observacion")
			info = Observacion();
		else if (artefacto === "Visita")
			info = Visita();
		else if (artefacto === "Demostracion")
			info = Demostracion();
		else if (artefacto === "Ensayo")
			info = Ensayo();
		else if (artefacto === "Simulacion")
			info = Simulacion();
		else if (artefacto === "Preguntas")
			info = Preguntas();
		else if (artefacto === "Tutoria")
			info = Tutoria();
		else if (artefacto === "LluviaIdeas")
			info = LluviaIdeas();
		else if (artefacto === "GrupoEstudio")
			info = GrupoEstudio();
		else if (artefacto === "Pelicula")
			info = Pelicula();
		else if (artefacto === "Video")
			info = Video();
		else if (artefacto === "Libro")
			info = Libro();
		else if (artefacto === "ArticuloWeb")
			info = ArticuloWeb();
		else if (artefacto === "ArticuloPDF")
			info = ArticuloPDF();
		else if (artefacto === "Revista")
			info = Revista();
		else if (artefacto === "EstudioCaso")
			info = EstudioCaso();
		else if (artefacto === "MarcoLogico")
			info = MarcoLogico();
		else if (artefacto === "MapaConceptual")
			info = MapaConceptual();
		else if (artefacto === "ArbolProblemas")
			info = ArbolProblemas();
		else if (artefacto === "ProyectoInvestigacion")
			info = ProyectoInvestigacion();
		else if (artefacto === "Ejercicios")
			info = Ejercicios();
		else if (artefacto === "Conferencia")
			info = Conferencia();
		else if (artefacto === "MesaRedonda")
			info = MesaRedonda();
		else if (artefacto === "Panel")
			info = Panel();
		else
			info = Simposio();
		
		BootstrapDialog.show({
			title: info.title,
			message: info.message,
			type: BootstrapDialog.TYPE_INFO,
			buttons: [{
				label: "Cerrar",
				cssClass: "btn-info",
				action: function(dialog) {
					dialog.close();
				}
			}]
		});
	}
	
	return {
		mostrarInfoArtefacto: _mostrarInfoArtefacto
	};
})();