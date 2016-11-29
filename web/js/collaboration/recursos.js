var Recursos = (function() {
	/**
	 * Encapsula el nombre del recurso en un elemento option del select.
	 * 
	 * @param {string} recurso El nombre del recurso.
	 * @param {string} opcionSeleccionada Si se desea que algún elemento del SELECT
	 * esté seleccionada, indicar su valor.
	 * @returns {String} Código HTML listo para ser incrustado.
	 */
	function _codigoSelect(recurso, opcionSeleccionada) {
		return '<option value="'
			+ recurso
			+ '"'
			+ (recurso === opcionSeleccionada ? " selected>" : ">")
			+ recurso
			+ '</option>';
	}

	/**
	 * Convierte la lista de recursos en código HTML para la etiqueta SELECT,
	 * donde cada opción es el nombre del recurso.
	 * 
	 * @param {string} opcionSeleccionada Si se desea que algún elemento del SELECT
	 * esté seleccionada, indicar su valor.
	 * @returns {String} Código HTML listo para ser incrustado.
	 */
	function _obtenerSelectsDeRecursos(opcionSeleccionada) {
		var codigo = '<select class="form-control">'
			+ '<option value="sin-recurso">Sin recurso adjunto</option>';
		var options = NOMBRES_RECURSOS.map(function(e) {
			return _codigoSelect(e, opcionSeleccionada);
		}).join('');

		return codigo + options + '</select>';
	}
	
	return {
		obtenerSelectsDeRecursos: _obtenerSelectsDeRecursos
	};
})();