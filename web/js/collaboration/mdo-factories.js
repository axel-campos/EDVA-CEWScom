var MDOFactories = (function() {
	var _VivenciaFactory = (function() {
		function Observacion() {
			return "<div class='mdo-vivencia-observacion panel panel-success'>\n\
						<div class='panel-heading'><strong>Observación</strong></div>\n\
						<div class='panel-body'>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</div>";
		}
		
		function Visita() {
			return "<div class='mdo-vivencia-visita panel panel-success'>\n\
						<div class='panel-heading'><strong>Visita</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Demostracion() {
			return "<div class='mdo-vivencia-demostracion panel panel-success'>\n\
						<div class='panel-heading'><strong>Demostración</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Ensayo() {
			return "<div class='mdo-vivencia-ensayo panel panel-success'>\n\
						<div class='panel-heading'><strong>Ensayo</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Simulacion() {
			return "<div class='mdo-vivencia-simulacion panel panel-success'>\n\
						<div class='panel-heading'><strong>Simulación</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}

		function JuegoRol() {
			return "<div class='mdo-vivencia-juegorol panel panel-success'>\n\
						<div class='panel-heading'><strong>Juego de Rol</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
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
			else if (tipo === "JuegoRol")
				return JuegoRol();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='Observacion'><div class='box box1 shadow1'><h5>Observación</h5></div></div>",
				"<div class='Visita'><div class='box box2 shadow1'><h5>Visita</h5></div></div>",
				"<div class='Demostracion'><div class='box box2 shadow1'><h5>Demostración</h5></div></div>",
				"<div class='Ensayo'><div class='box box3 shadow1'><h5>Ensayo</h5></div></div>",
				"<div class='Simulacion'><div class='box box4 shadow1'><h5>Simulación</h5></div></div>",
				"<div class='JuegoRol'><div class='box box5 shadow1'><h5>Juego de Rol</h5></div></div>"
			];
		}

		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _ConceptualizacionFactory = (function() {
		function Dinamica() {
			return "<div class='mdo-conceptualizacion-dinamica panel panel-warning'>\n\
						<div class='panel-heading'><strong>Dinámica</strong></div>\n\
						<div class='panel-body'>\n\
							<input type='text' class='form-control' />\n\
						</div>\n\
					</div>";
		}
		
		function Preguntas() {
			return "<div class='mdo-conceptualizacion-preguntas panel panel-warning'>\n\
						<div class='panel-heading'><strong>Preguntas</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Tutoria() {
			return "<div class='mdo-conceptualizacion-tutoria panel panel-warning'>\n\
						<div class='panel-heading'><strong>Tutoría</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function LluviaIdeas() {
			return "<div class='mdo-conceptualizacion-lluviaideas panel panel-warning'>\n\
						<div class='panel-heading'><strong>Lluvia de Ideas</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function GrupoEstudio() {
			return "<div class='mdo-conceptualizacion-grupoestudio panel panel-warning'>\n\
						<div class='panel-heading'><strong>Grupo de Estudio</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
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
			return "<div class='mdo-aplicacion-estudiocasos panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Estudio de Casos</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function MarcoLogico() {
			return "<div class='mdo-aplicacion-marcologico panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Marco Lógico</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function MapaConceptual() {
			return "<div class='mdo-aplicacion-mapaconceptual panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Mapa Conceptual</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function ArbolProblemas() {
			return "<div class='mdo-aplicacion-arbolproblemas panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Árbol de Problemas</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function ProyectoInvestigacion() {
			return "<div class='mdo-aplicacion-proyectoinvestigacion panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Proyecto de Investigación</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function ProyectoProduccion() {
			return "<div class='mdo-aplicacion-proyectoproduccion panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Proyecto de Producción</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Ejercicios() {
			return "<div class='mdo-aplicacion-ejercicios panel panel-default panel-mdo-aplicacion'>\n\
						<div class='panel-heading'><strong>Ejercicios</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
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
			return "<div class='mdo-ampliacion-conferencia panel panel-default panel-mdo-ampliacion'>\n\
						<div class='panel-heading'><strong>Conferencia</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function MesaRedonda() {
			return "<div class='mdo-ampliacion-mesaredonda panel panel-default panel-mdo-ampliacion'>\n\
						<div class='panel-heading'><strong>Mesa Redonda</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Panel() {
			return "<div class='mdo-ampliacion-panel panel panel-default panel-mdo-ampliacion'>\n\
						<div class='panel-heading'><strong>Panel</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
		}
		
		function Simposio() {
			return "<div class='mdo-ampliacion-simposio panel panel-default panel-mdo-ampliacion'>\n\
						<div class='panel-heading'><strong>Simposio</strong></div>\n\
						<div class='panel-body'>\n\
							<textarea class='form-control'></textarea>\n\
						</div>\n\
					</div>";
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