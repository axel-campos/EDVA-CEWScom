package interceptor;

import modelo.pojo.Usuario;

/**
 * Esta interfaz tiene como propósito marcar aquellos Actions que requieran que
 * el usuario haya iniciado sesión para llevar a cabo su función. Los Action que
 * implementen esta interfaz deberán mantener una referencia hacia el objeto de la
 * clase Usuario que vive en la sesión.
 */
public interface AuthenticatedUser {
	void setUsuario(Usuario usuario);
}