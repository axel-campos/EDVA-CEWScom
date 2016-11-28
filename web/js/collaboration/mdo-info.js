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
			message: "La <b>tutoría</b> está orientada a revitalizar la práctica de la docencia, brindando a los estudiantes atención"
				+ " personalizada o grupal durante su proceso formativo, con el propósito de detectar de manera oportuna y clara los"
				+ " factores de riesgo que pueden afectar el desempeño académico de los estudiantes.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la tutoría.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la tutoría.<br>"
				+ "<b class='text-success'>Objetivos:</b> Los objetivos a lograr con la tutoría.<br>"
				+ "<b class='text-success'>Temas a tratar:</b> El contenido que se repasará en la tutoría.<br>"
				+ "<b class='text-success'>Material de apoyo:</b> Los materiales complementarios a utilizar durante la tutoría."
		};
	}
	
	function LluviaIdeas() {
		return {
			title: "Artefacto <i>Lluvia de Ideas</i>",
			message: "La <b>lluvia de ideas</b> es una técnica grupal en la cual se realiza un esfuerzo colectivo para encontrar la"
				+ " solución a un problema por medio de la generación espontánea de ideas por parte de todos los integrantes.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la lluvia de ideas.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la lluvia de ideas.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a tratar durante la lluvia de ideas.<br>"
				+ "<b class='text-success'>Problemática:</b> El problema a resolver con la lluvia de ideas.<br>"
				+ "<b class='text-success'>Preguntas clave.</b> Conjunto de preguntas iniciales para empezar la lluvia de ideas."
		};
	}
	
	function GrupoEstudio() {
		return {
			title: "Artefacto <i>Grupo de Estudio</i>",
			message: "Un <b>grupo de estudio</b> es un conjunto de personas que trabajan colaborativamente por una causa común: adquirir"
				+ " y compartir conocimientos acerca de un tema en concreto.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del grupo de estudio.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del grupo de estudio.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a tratar en el grupo de estudio.<br>"
				+ "<b class='text-success'>Integrantes por grupo:</b> El número de integrantes del grupo de estudio.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos que se entregarán durante y al final de la sesión del grupo."
		};
	}
	
	function Pelicula() {
		return {
			title: "Artefacto <i>Película</i>",
			message: "Una <b>película</b> puede servir como refuerzo al material teórico y práctico enseñado por el docente en el salón"
				+ " de clases. La película debería mostrarse en segmentos periódicos, con el fin de discutir los eventos que ocurren en"
				+ " la narrativa y poder vincularlos a la temática del curso.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la película.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la película.<br>"
				+ "<b class='text-success'>Director:</b> El director de la película.<br>"
				+ "<b class='text-success'>Productora:</b> La empresa productora de la película.<br>"
				+ "<b class='text-success'>País o región:</b> El país de origen de la película.<br>"
				+ "<b class='text-success'>Año:</b> El año de estreno de la película."
		};
	}
	
	function Video() {
		return {
			title: "Artefacto <i>Video</i>",
			message: "Un <b>video</b> puede servir como refuerzo al material teórico y práctico enseñado por el docente en el salón de"
				+ " clases. Si el video es largo, debería mostrarse en segmentos periódicos, con el fin de discutir los eventos que"
				+ " ocurren en él y poder vincularlos a la temática del curso.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del video.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del video.<br>"
				+ "<b class='text-success'>URL del video:</b> La dirección URL del video."
		};
	}
	
	function Libro() {
		return {
			title: "Artefacto <i>Libro</i>",
			message: "Los <b>libros</b> son una excelente fuente de conocimientos, tanto para alumnos como para docentes. Una amplia"
				+ " selección de fuentes bibliográficas ofrece a sus lectores las teorías, tratados y resultados empíricos que han sido"
				+ " estudiados y recolectados con el paso del tiempo.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título: </b> El título del libro.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del libro.<br>"
				+ "<b class='text-success'>Autor:</b> El autor del libro.<br>"
				+ "<b class='text-success'>Año:</b> Su año de publicación.<br>"
				+ "<b class='text-success'>Ciudad:</b> La ciudad en la que fue publicado.<br>"
				+ "<b class='text-success'>Editorial:</b> La casa editorial del libro.<br>"
				+ "<b class='text-success'>Volumen:</b> El volumen del libro."
		};
	}
	
	function ArticuloWeb() {
		return {
			title: "Artefacto <i>Artículo Web</i>",
			message: "A diferencia de otros medios de información estáticos, la información almacenada en la Web está siendo constantemente"
				+ " actualizada con los más recientes acontecimientos científicos y tecnológicos, por lo que saber utilizarla se ha convertido"
				+ " en una habilidad indispensable para estar a la vanguardia en cualquier área. Un <b>artículo Web</b> provee"
				+ " una manera rápida y sencilla de acceder a contenidos de distinta índole, muchos de los cuales son relevantes para los temas"
				+ " que se enseñan en el salón de clases.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del artículo Web.<br>"
				+ "<b class='text-success'>Autor:</b> El autor del artículo Web.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del artículo Web.<br>"
				+ "<b class='text-success'>Nombre del sitio Web:</b> El nombre del sitio donde está alojado el artículo.<br>"
				+ "<b class='text-success'>Año en el que se realizó la consulta:</b> El año en el que el artículo fue consultado.<br>"
				+ "<b class='text-success'>Mes en el que se realizó la consulta:</b> El mes en el que el artículo fue consultado.<br>"
				+ "<b class='text-success'>Día en el que se realizó la consulta:</b> El día en el que el artículo fue consultado.<br>"
				+ "<b class='text-success'>URL:</b> La dirección HTTP del artículo Web."
		};
	}
	
	function ArticuloPDF() {
		return {
			title: "Artefacto <i>Artículo PDF</i>",
			message: "Muchos artículos de interés para alumnos y docentes están presentes en formato PDF, por lo que pueden compartirse"
				+ " fácilmente y visualizarse en una gran cantidad de dispositivos, como teléfonos, tabletas y computadoras.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del artículo.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del artículo.<br>"
				+ "<b class='text-success'>URL del artículo:</b> Si el artículo PDF está disponible en la Web, utilizar su dirección HTTP."
		};
	}
	
	function Revista() {
		return {
			title: "Artefacto <i>Revista</i>",
			message: "Las <b>revistas científicas</b> son el principal instrumento de transferencia de información científica que adelanta"
				+ " hipótesis y conclusiones para desarrollar posteriormente en libros.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> Título del artículo.<br>"
				+ "<b class='text-success'>Autor:</b> Autor del artículo.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del artículo.<br>"
				+ "<b class='text-success'>Nombre de la revista:</b> El nombre de la revista científica.<br>"
				+ "<b class='text-success'>Año:</b> El año de publicación de la revista.<br>"
				+ "<b class='text-success'>Páginas:</b> Número de páginas de la revista.<br>"
				+ "<b class='text-success'>Volumen:</b> El volumen de la revista.<br>"
				+ "<b class='text-success'>Número:</b> El número de publicación de la vista."
		};
	}
	
	function EstudioCaso() {
		return {
			title: "Artefacto <i>Estudio de Caso</i>",
			message: "El <b>estudio de caso</b> es un método de investigación que consiste en estudiar a una persona, organización o situación durante"
				+ " un determinado tiempo y lugar. El estudio de caso puede llevarse a cabo por medio de diferentes medios de investigación; por ejemplo,"
				+ " cuestionarios, entrevistas, observacionesd de campo o historias de casos, entre otros.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> Título del estudio.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del estudio.<br>"
				+ "<b class='text-success'>Objetivos:</b> Los objetivos a cumplir durante el desarrollo del estudio.<br>"
				+ "<b class='text-success'>Problemática:</b> El problema a resolver con el estudio.<br>"
				+ "<b class='text-success'>Métodos de investigación:</b> Los métodos a utilizar para desarrollar el estudio.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos que se entregarán durante y al final del estudio.<br>"
		};
	}
	
	function MarcoLogico() {
		return {
			title: "Artefacto <i>Marco Lógico</i>",
			message: "El <b>marco lógico</b> es una herramienta analítica para la planificación de proyectos mediante una serie de objetivos. El marco"
			 + " lógico de un proyecto generalmente toma la forma de una tabla de cuatro celdas, donde las filas representan los tipos de eventos que"
			 + " ocurren mientras se desarrolla el proyecto (<i>Actividades, Salidas, Propósito y Meta</i>) y las columnas representan los tipos de"
			 + " información de los eventos (<i>Narrativa, Indicadores Objetivamente Verificables y Fuentes de Verificación</i>).<br><br>"
			 + "Este artefacto consta de:<br><br>"
			 + "<b class='text-success'>Título:</b> El título del marco lógico.<br>"
			 + "<b class='text-success'>Descripción:</b> Una breve descripción del marco lógico.<br>"
			 + "<b class='text-success'>Objetivo general:</b> La meta que se pretende lograr con el proyecto.<br>"
			 + "<b class='text-success'>Objetivos específicos:</b> Los logros secundarios a realizar para lograr la meta.<br>"
			 + "<b class='text-success'>Resultados esperados:</b> Los resultados que se esperan con la realización del proyecto.<br>"
			 + "<b class='text-success'>Actividades a realizar:</b> El conjunto de actividades para cumplir los objetivos especificados.<br>"
			 + "<b class='text-success'>Indicadores:</b> Los indicadores medibles y objetivos para evaluar el proyecto.<br>"
			 + "<b class='text-success'>Fuentes de verificación:</b> Las fuentes con las cuales se valida el progreso del proyecto.<br>"
			 + "<b class='text-success'>Supuestos:</b> Los posibles eventos que podrían repercutir de manera positiva o negativa sobre el proyecto."
		};
	}
	
	function MapaConceptual() {
		return {
			title: "Artefacto <i>Mapa Conceptual</i>",
			message: "El <b>mapa conceptual</b> es una técnica usada para la representación gráfica del conocimiento. Un mapa conceptual es"
				+ " una red de conceptos. En esta red, los nodos represnetan los conceptos, y los enlaces representan las relaciones entre ellos.<br><br>"
				+ "Este artefacto costa de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del mapa conceptual.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del mapa a realizar.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a tomar en cuenta para la realización del mapa conceptual.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos a entregar durante y al final de la realización del mapa conceptual.<br>"
		};
	}
	
	function ArbolProblemas() {
		return {
			title: "Artefacto <i>Árbol de Problemas</i>",
			message: "El <b>árbol de problemas</b> es una técnica gráfica que tiene como finalidad identificar los principales problemas de un"
				+ " proyecto, así como sus causas y sus consecuencias. Esto permite a los planificadores de proyectos definir objetivos claros"
				+ " y prácticos, así como plantear estrategias para poder cumplirlos.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del árbol de problemas.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del árbol a realizar.<br>"
				+ "<b class='text-success'>Problemática principal:</b> El principal problema a resolver dentro del proyecto.<br>"
				+ "<b class='text-success'>Causas:</b> Las posibles causas que llevaron a la aparición del problema principal.<br>"
				+ "<b class='text-success'>Problemas secundarios:</b> El problema principal desglosado en sus partes principales.<br>"
				+ "<b class='text-success'>Efectos:</b> Las consecuencias que ha provocado el problema principal.<br>"
		};
	}
	
	function ProyectoInvestigacion() {
		return {
			title: "Artefacto <i>Proyecto de Investigación</i>",
			message: "El <b>proyecto de investigación</b> es un procedimiento que, siguiendo el método científico, pretende recabar"
				+ " todo tipo de información y formular hipótesis acerca de cierto fenómeno social o científico, empleando las diferentes"
				+ " formas de investigación.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del proyecto.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del proyecto a realizar.<br>"
				+ "<b class='text-success'>Objetivos:</b> Los propósitos de la investigación.<br>"
				+ "<b class='text-success'>Marco teórico:</b> El compendio científico sobre el cual estará basada esta investigación.<br>"
				+ "<b class='text-success'>Hipótesis:</b> La suposición inicial de la investigación que será puesta a prueba.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos a entregar durante y al final de la investigación.<br>"
		};
	}
	
	function Ejercicios() {
		return {
			title: "Artefacto <i>Ejercicios</i>",
			message: "La realización de <b>ejercicios</b> en clase permite reforzar de manera práctica los conocimientos teóricos enseñados"
				+ " por el docente. La práctica constante ayuda a asimilar y cimentar la información aprendida hasta el momento.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la serie de ejercicios.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de los ejercicios a realizar.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a reforzar por medio de los ejercicios.<br>"
				+ "<b class='text-success'>Ejercicios:</b> Los ejercicios en cuestión.<br>"
				+ "<b class='text-success'>Entregables:</b> Los trabajos a entregar durante y al final de la serie de ejercicios.<br>"
		};
	}
	
	function Conferencia() {
		return {
			title: "Artefacto <i>Conferencia</i>",
			message: "Una <b>conferencia</b> es una reunión de gente que debate y expone sobre un determinado asunto. En la conferencia, se"
				+ " desarrolla una confrontación de ideas en relación a un determinado tema considerado de importancia para los participantes.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la conferencia.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la conferencia.<br>"
				+ "<b class='text-success'>Objetivos:</b> El propósito de la realización de la conferencia.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a desarrollar en la conferencia."
		};
	}
	
	function MesaRedonda() {
		return {
			title: "Artefacto <i>Mesa Redonda</i>",
			message: "En la <b>mesa redonda</b>, un grupo de expertos (pueden ser alumnos) sostienen puntos de vista divergentes o contradictorioss sobre"
				+ " un mismo tema, el cual exponen ante el grupo en forma sucesiva. Es útil para dar a conocer a un grupo de alumnos los puntos de vista"
				+ " divergentes o contradictorios sobre un determinado tema o cuestión.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título de la mesa redonda.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción de la mesa redonda.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a desarrollar en la mesa redonda.<br>"
				+ "<b class='text-success'>Número de integrantes:</b> El número de integrantes de la mesa redonda.<br>"
				+ "<b class='text-success'>Tiempo de exposición:</b> La duración de la mesa redonda."
		};
	}
	
	function Panel() {
		return {
			title: "Artefacto <i>Panel</i>",
			message: "En un <b>panel</b>, un equipo de alumnos que fungen como expertos discute un tema en forma de diálogo o conversación ante el grupo."
				+ " En el panel, los <i>expertos</i> no exponen ni actúan como oradores, sino que dialogan, conversan y debaten entre sí el tema propuesto,"
				+ " desde sus particulares puntos de vista, cada uno especializado en una parte del tema general.<br><br>"
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del panel..<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del panel.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a desarrollar en el panel.<br>"
				+ "<b class='text-success'>Número de integrantes:</b> El número de integrantes del panel.<br>"
				+ "<b class='text-success'>Tiempo de exposición:</b> La duración del panel."
		};
	}
	
	function Simposio() {
		return {
			title: "Artefacto <i>Simposio</i>",
			message: "En el <b>simposio</b>, un equipo de expertos (puede ser un grupo de alumnos o profesores invitados) desarrolla diferentes aspectos de"
				+ " un tema o de un problema en forma sucesiva ante un grupo. Los expertos exponen al auditorio sus ideas o conocimientos en forma sucesiva,"
				+ " integrando así un panorama lo más completo posible acerca de la cuestión de que se trate. En el simposio, los integrantes exponen"
				+ " individualmente y en forma sucesiva durante un determinado lapso; sus ideas pueden ser coincidentes o no serlo, lo importante es que cada"
				+ " uno de ellos ofrezca un aspecto particular del tema."
				+ "Este artefacto consta de:<br><br>"
				+ "<b class='text-success'>Título:</b> El título del simposio.<br>"
				+ "<b class='text-success'>Descripción:</b> Una breve descripción del simposio.<br>"
				+ "<b class='text-success'>Temática:</b> Los temas a desarrollar en el simposio.<br>"
				+ "<b class='text-success'>Número de integrantes:</b> El número de integrantes del simposio.<br>"
				+ "<b class='text-success'>Tiempo de exposición por integrante:</b> La duración de la exposición de cada integrante."
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