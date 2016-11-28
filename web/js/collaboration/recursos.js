var Recursos = (function() {
	
	/**
	 * Encapsula el nombre del recurso en un elemento option del select.
	 * 
	 * @param {string} recurso El nombre del recurso.
	 * @returns {String} Código HTML listo para ser incrustado.
	 */
	function _codigoSelect(recurso) {
		return '<option value="'
			+ encodeURIComponent(recurso)
			+ '">'
			+ recurso
			+ '</option>';
	}

	/**
	 * Convierte la lista de recursos en código HTML para la etiqueta select,
	 * donde cada opción es el nombre del recurso.
	 * 
	 * @returns {String} Código HTML listo para ser incrustado.
	 */
	function _obtenerSelectsDeRecursos() {
		var codigo = '<select id="recurso" class="form-control">'
			+ '<option value="sin-recurso">Sin recurso adjuntado</option>';
		var options = NOMBRES_RECURSOS.map(function(e) {
			return _codigoSelect(e);
		}).join('');

		return codigo + options + '</select>';
	}
	
	return {
		obtenerSelectsDeRecursos: _obtenerSelectsDeRecursos
	};
})();