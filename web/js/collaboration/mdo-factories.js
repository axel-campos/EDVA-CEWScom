var MDOFactories = (function() {
	var _VivenciaFactory = (function() {
		function Observacion() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-vivencia-observacion event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Observación</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Observacion\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
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
						</div>\n\
					</li>";
		}
		
		function Visita() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-vivencia-visita event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Visita</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Visita\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
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
						</div>\n\
					</li>";
		}
		
		function Demostracion() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-vivencia-demostracion event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Demostración</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Demostracion\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivo:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Material necesario:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Procedimiento:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Ensayo() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-vivencia-ensayo event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Ensayo</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Ensayo\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
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
						</div>\n\
					</li>";
		}
		
		function Simulacion() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-vivencia-simulacion event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Simulación</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Simulacion\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
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
						</div>\n\
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
		function Preguntas() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-conceptualizacion-preguntas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Preguntas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Preguntas\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Preguntas a realizar:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Tutoria() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-conceptualizacion-tutoria event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Tutoría</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Tutoria\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temas a tratar:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Material de apoyo:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function LluviaIdeas() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-conceptualizacion-lluviaideas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Lluvia de Ideas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"LluviaIdeas\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Problemática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Preguntas clave:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function GrupoEstudio() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-conceptualizacion-grupoestudio event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Grupo de Estudio</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"GrupoEstudio\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Integrantes por grupo:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
						</div>\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "Preguntas")
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
				"<div class='Preguntas'><div class='box box1 shadow1'><h5>Preguntas</h5></div></div>",
				"<div class='Tutoria'><div class='box box2 shadow1'><h5>Tutoría</h5></div></div>",
				"<div class='LluviaIdeas'><div class='box box3 shadow1'><h5>Lluvia de Ideas</h5></div></div>",
				"<div class='GrupoEstudio'><div class='box box4 shadow1'><h5>Grupo de Estudio</h5></div></div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _DocumentacionFactory = (function() {
		function Pelicula() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-pelicula event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Película</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Pelicula\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Director:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Productora:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>País o región:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Video() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-video event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Video</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Video\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Nombre:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>URL del video:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Libro() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-libro event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Libro</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Libro\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Ciudad:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Editorial:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function ArticuloWeb() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-articuloweb event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Artículo Web</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"ArticuloWeb\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Nombre del sitio Web:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Año en que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Mes en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Día en el que se realizó la consulta:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>URL:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function ArticuloPDF() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-articulopdf event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Artículo PDF</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"ArticuloPDF\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Nombre:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>URL del artículo:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Revista() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-documentacion-revista event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Revista</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Revista\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Autor:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Nombre de la revista:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Año:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Páginas:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Volumen:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Número:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
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
		function EstudioCaso() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-estudiocaso event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Estudio de Caso</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"EstudioCaso\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Problemática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Métodos de investigación:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function MarcoLogico() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-marcologico event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Marco Lógico</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"MarcoLogico\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivo general:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivos específicos:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Resultados esperados:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Actividades a realizar:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Indicadores:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Fuentes de verificación:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Supuestos:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function MapaConceptual() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-mapaconceptual event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Mapa Conceptual</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"MapaConceptual\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function ArbolProblemas() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-arbolproblemas event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Árbol de Problemas</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"ArbolProblemas\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Problemática principal:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Causas:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Problemas secundarios:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Efectos:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function ProyectoInvestigacion() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-proyectoinvestigacion event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Proyecto de Investigación</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"ProyectoInvestigacion\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Marco teórico:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Hipótesis:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Ejercicios() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-aplicacion-ejercicios event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Ejercicios</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Ejercicios\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Ejercicios:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Entregables:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function _crear(tipo) {
			if (tipo === "EstudioCaso")
				return EstudioCaso();
			else if (tipo === "MarcoLogico")
				return MarcoLogico();
			else if (tipo === "MapaConceptual")
				return MapaConceptual();
			else if (tipo === "ArbolProblemas")
				return ArbolProblemas();
			else if (tipo === "ProyectoInvestigacion")
				return ProyectoInvestigacion();
			else if (tipo === "Ejercicios")
				return Ejercicios();
			else
				return null;
		}
		
		function _listaArtefactos() {
			return [
				"<div class='EstudioCaso'><div class='box box1 shadow1'><h5>Estudio de Caso</h5></div></div>",
				"<div class='MarcoLogico'><div class='box box2 shadow1'><h5>Marco Lógico</h5></div></div>",
				"<div class='MapaConceptual'><div class='box box3 shadow1'><h5>Mapa Conceptual</h5></div></div>",
				"<div class='ArbolProblemas'><div class='box box4 shadow1'><h5>Árbol de Problemas</h5></div></div>",
				"<div class='ProyectoInvestigacion'><div class='box box5 shadow1'><h5>Proyecto de Investigación</h5></div></div>",
				"<div class='Ejercicios'><div class='box box6 shadow1'><h5>Ejercicios</h5></div></div>"
			];
		}
		
		return {
			crear: _crear,
			listaArtefactos: _listaArtefactos
		};
	})();
	
	var _AmpliacionFactory = (function() {
		function Conferencia() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-ampliacion-conferencia event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Conferencia</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Conferencia\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Objetivos:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function MesaRedonda() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-ampliacion-mesaredonda event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Mesa Redonda</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"MesaRedonda\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Tiempo de exposición:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Panel() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-ampliacion-panel event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Panel</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Panel\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Tiempo de exposición:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
					</li>";
		}
		
		function Simposio() {
			var id = Math.random().toString(36).substring(2);
			return "<li class='mdo-ampliacion-simposio event'>\n\
						<h2 class='heading'>\n\
							<a data-toggle='collapse' href='#" + id + "'>Simposio</a>\n\
							<button class='btn btn-danger btn-xs btn-eliminar-artefacto' onclick='eliminarArtefacto(this);'>\n\
								<span class='glyphicon glyphicon-remove-circle'></span>&nbsp;\n\
							</button>\n\
							<button class='btn btn-info btn-xs btn-info-artefacto' onclick='MDOInfo.mostrarInfoArtefacto(\"Simposio\");'>\n\
								<span class='glyphicon glyphicon-info-sign'></span>&nbsp;\n\
							</button>\n\
						</h2>\n\
						<div id='" + id + "' class='collapse'>\n\
							<label>Título:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Descripción:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Temática:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Número de integrantes:</label>\n\
							<input type='text' class='form-control input-sm' /><br>\n\
							<label>Tiempo de exposición por integrante:</label>\n\
							<input type='text' class='form-control input-sm' />\n\
						</div>\n\
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
				"<div class='Conferencia'><div class='box box1 shadow1'><h5>Conferencia</h5></div></div>",
				"<div class='MesaRedonda'><div class='box box2 shadow1'><h5>Mesa Redonda</h5></div></div>",
				"<div class='Panel'><div class='box box3 shadow1'><h5>Panel</h5></div></div>",
				"<div class='Simposio'><div class='box box4 shadow1'><h5>Simposio</h5></div></div>"
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