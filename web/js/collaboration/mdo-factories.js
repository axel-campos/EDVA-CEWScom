var MDOFactories = (function() {
	var _VivenciaFactory = (function() {
		function Observacion() {
			return "<li class='mdo-vivencia-observacion event'>\n\
						<h2 class='heading'>Observación</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Pregunta:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Fenómeno a observar:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Posible explicación:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Posible resultado:</label>\n\
						<input type='text' class='form-control input-sm' />\n\
					</li>";
		}
		
		function Visita() {
			return "<li class='mdo-vivencia-visita event'>\n\
						<h2 class='heading'>Visita</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Lugar a visitar:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Temática del lugar:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Propósito:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Objetivos:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Entregables:</label>\n\
						<input type='text' class='form-control input-sm' />\n\
					</li>";
		}
		
		function Demostracion() {
			return "<li class='mdo-vivencia-demostracion event'>\n\
						<h2 class='heading'>Demostración</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Objetivo:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Material necesario:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Procedimiento:</label>\n\
						<input type='text' class='form-control input-sm' />\n\
					</li>";
		}
		
		function Ensayo() {
			return "<li class='mdo-vivencia-ensayo event'>\n\
						<h2 class='heading'>Ensayo</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Descripción:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Temática:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Requisitos:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Tiempo de realización:</label>\n\
						<input type='text' class='form-control input-sm' />\n\
					</li>";
		}
		
		function Simulacion() {
			return "<li class='mdo-vivencia-simulacion event'>\n\
						<h2 class='heading'>Simulación</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Temática:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Descripción:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Roles:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Material necesario:</label>\n\
						<input type='text' class='form-control input-sm' /><br>\n\
						<label>Procedimiento:</label>\n\
						<input type='text' class='form-control input-sm' />\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "Observacion")
				return Observacion();
			else if (tipo === "Visita")
				return Visita();
			else if (tipo === "Demostracion")
				return Demostracion();
			else if (tipo === "Ensayo")
				return Ensayo();
			else if(tipo === "Simulacion")
				return Simulacion();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='Observacion'><div class='box box1 shadow1'><h5>Observación</h5></div></div>",
				"<div class='Visita'><div class='box box2 shadow1'><h5>Visita</h5></div></div>",
				"<div class='Demostracion'><div class='box box2 shadow1'><h5>Demostración</h5></div></div>",
				"<div class='Ensayo'><div class='box box3 shadow1'><h5>Ensayo</h5></div></div>",
				"<div class='Simulacion'><div class='box box4 shadow1'><h5>Simulación</h5></div></div>"
			];
		}

		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _ConceptualizacionFactory = (function() {
		function Dinamica() {
			return "<li class='mdo-conceptualizacion-dinamica event'>\n\
						<h2 class='heading'>Dinámica</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function Preguntas() {
			return "<li class='mdo-conceptualizacion-preguntas event'>\n\
						<h2 class='heading'>Preguntas</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function Tutoria() {
			return "<li class='mdo-conceptualizacion-tutoria event'>\n\
						<h2 class='heading'>Tutoría</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function LluviaIdeas() {
			return "<li class='mdo-conceptualizacion-lluviaideas event'>\n\
						<h2 class='heading'>Lluvia de Ideas</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function GrupoEstudio() {
			return "<li class='mdo-conceptualizacion-grupoestudio event'>\n\
						<h2 class='heading'>Grupo de Estudio</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "Dinamica")
				return Dinamica();
			else if (tipo === "Preguntas")
				return Preguntas();
			else if (tipo === "Tutoria")
				return Tutoria();
			else if (tipo === "LluviaIdeas")
				return LluviaIdeas();
			else if (tipo === "GrupoEstudio")
				return GrupoEstudio();
			else
				return null;
		}
		
		function _listaArtefactos(){
			return [
				"<div class='Dinamica'>Dinámica</div>",
				"<div class='Preguntas'>Preguntas</div>",
				"<div class='Tutoria'>Tutoría</div>",
				"<div class='LluviaIdeas'>Lluvia de Ideas</div>",
				"<div class='GrupoEstudio'>Grupo de Estudio</div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _DocumentacionFactory = (function() {
		function Pelicula() {
			return "<li class='mdo-documentacion-pelicula event'>\n\
						<h2 class='heading'>Película</h2>\n\
						<div class='col-md-6'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Director:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
						<div class='col-md-6'>\n\
							<label>Productora:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>País o región:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</li>";
		}
		
		function Video() {
			return "<li class='mdo-documentacion-video event'>\n\
						<h2 class='heading'>Video</h2>\n\
						<label>Nombre:</label>\n\
						<input type='text' class='form-control' /><br>\n\
						<label>Descripción:</label>\n\
						<input type='text' class='form-control' /><br>\n\
						<label>URL del video:</label>\n\
						<input type='text' class='form-control' />\n\
						<br>\n\
						<button class='btn btn-primary'>O puedes subir un video</button>\n\
					</li>";
		}
		
		function Libro() {
			return "<li class='mdo-documentacion-libro event'>\n\
						<h2 class='heading'>Libro</h2>\n\
						<div class='col-md-6'>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
						<div class='col-md-6'>\n\
							<label>Ciudad:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Editorial:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</li>";
		}
		
		function ArticuloWeb() {
			return "<li class='mdo-documentacion-articuloweb event'>\n\
						<h2 class='heading'>Artículo Web</h2>\n\
						<div class='col-md-6'>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Nombre del sitio Web:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
						<div class='col-md-6'>\n\
							<label>Año en que se realizó la consulta:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Mes en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Día en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>URL:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</li>";
		}
		
		function ArticuloPDF() {
			return "<li class='mdo-documentacion-articulopdf event'>\n\
						<h2 class='heading'>Artículo PDF</h2>\n\
						<label>Nombre:</label>\n\
						<input type='text' class='form-control' /><br>\n\
						<label>Descripción:</label>\n\
						<input type='text' class='form-control' /><br>\n\
						<label>URL del artículo:</label>\n\
						<input type='text' class='form-control' />\n\
						<br>\n\
						<button class='btn btn-primary'>O puedes subir un PDF</button>\n\
					</li>";
		}
		
		function Revista() {
			return "<li class='mdo-documentacion-revista event'>\n\
						<h2 class='heading'>Revista</h2>\n\
						<div class='col-md-6'>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Nombre de la revista:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
						<div class='col-md-6'>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Páginas:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control' /><br>\n\
							<label>Número:</label>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "Pelicula")
				return Pelicula();
			else if (tipo === "Video")
				return Video();
			else if (tipo === "Libro")
				return Libro();
			else if (tipo === "ArticuloWeb")
				return ArticuloWeb();
			else if (tipo === "ArticuloPDF")
				return ArticuloPDF();
			else if (tipo === "Revista")
				return Revista();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='Pelicula'><div class='box box1 shadow1'><h5>Película</h5></div></div>",
				"<div class='Video'><div class='box box2 shadow1'><h5>Video</h5></div></div>",
				"<div class='Libro'><div class='box box3 shadow1'><h5>Libro</h5></div></div>",
				"<div class='ArticuloWeb'><div class='box box4 shadow1'><h5>Artículo Web</h5></div></div>",
				"<div class='ArticuloPDF'><div class='box box5 shadow1'><h5>Artículo PDF</h5></div></div>",
				"<div class='Revista'><div class='box box6 shadow1'><h5>Revista</h5></div></div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _AplicacionFactory = (function() {
		function EstudioCasos() {
			return "<li class='mdo-aplicacion-estudiocasos event'>\n\
						<h2 class='heading'>Caso de Estudio</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function MarcoLogico() {
			return "<li class='mdo-aplicacion-marcologico event'>\n\
						<h2 class='heading'>Marco Lógico</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function MapaConceptual() {
			return "<li class='mdo-aplicacion-mapaconceptual event'>\n\
						<h2 class='heading'>Mapa Conceptual</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function ArbolProblemas() {
			return "<li class='mdo-aplicacion-arbolproblemas event'>\n\
						<h2 class='heading'>Árbol de Problemas</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function ProyectoInvestigacion() {
			return "<li class='mdo-aplicacion-proyectoinvestigacion event'>\n\
						<h2 class='heading'>Proyecto de Investigación</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function ProyectoProduccion() {
			return "<li class='mdo-aplicacion-proyectoproduccion event'>\n\
						<h2 class='heading'>Proyecto de Producción</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function Ejercicios() {
			return "<li class='mdo-aplicacion-ejercicios event'>\n\
						<h2 class='heading'>Ejercicios</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "EstudioCasos")
				return EstudioCasos();
			else if (tipo === "MarcoLogico")
				return MarcoLogico();
			else if (tipo === "MapaConceptual")
				return MapaConceptual();
			else if (tipo === "ArbolProblemas")
				return ArbolProblemas();
			else if (tipo === "ProyectoInvestigacion")
				return ProyectoInvestigacion();
			else if (tipo === "ProyectoProduccion")
				return ProyectoProduccion();
			else if (tipo === "Ejercicios")
				return Ejercicios();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='EstudioCasos'>Casos de Estudio</div>",
				"<div class='MarcoLogico'>Marco Lógico</div>",
				"<div class='MapaConceptual'>Mapa Conceptual</div>",
				"<div class='ArbolProblemas'>Árbol de Problemas</div>",
				"<div class='ProyectoInvestigacion'>Proyecto de Investigación</div>",
				"<div class='ProyectoProduccion'>Proyecto de Producción</div>",
				"<div class='Ejercicios'>Ejercicios</div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _AmpliacionFactory = (function() {
		function Conferencia() {
			return "<li class='mdo-ampliacion-conferencia event'>\n\
						<h2 class='heading'>Conferencia</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function MesaRedonda() {
			return "<li class='mdo-ampliacion-mesaredonda event'>\n\
						<h2 class='heading'>Mesa Redonda</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function Panel() {
			return "<li class='mdo-ampliacion-panel event'>\n\
						<h2 class='heading'>Panel</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function Simposio() {
			return "<li class='mdo-ampliacion-simposio event'>\n\
						<h2 class='heading'>Simposio</h2>\n\
						<label>Título:</label>\n\
						<input type='text' class='form-control' />\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "Conferencia")
				return Conferencia();
			else if (tipo === "MesaRedonda")
				return MesaRedonda();
			else if (tipo === "Panel")
				return Panel();
			else if (tipo === "Simposio")
				return Simposio();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='Conferencia'>Conferencia</div>",
				"<div class='MesaRedonda'>Mesa Redonda</div>",
				"<div class='Panel'>Panel</div>",
				"<div class='Simposio'>Simposio</div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	return {
		VivenciasFactory: _VivenciaFactory,
		ConceptualizaciónFactory: _ConceptualizacionFactory,
		DocumentaciónFactory: _DocumentacionFactory,
		AplicaciónFactory: _AplicacionFactory,
		AmpliaciónFactory: _AmpliacionFactory
	};
})();