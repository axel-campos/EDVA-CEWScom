package modelo.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.pojo.EDVADB;

/**
 * Clase base de los DAO diseñados para trabajar con los POJOs de EDVADB.
 * Incluye los métodos necesarios para realizar la conexión con la base de datos,
 * además de otros métodos CRUD abstractos que serán anulados por las clases que
 * deriven de ésta.
 * 
 * @author kikemon
 */
public abstract class ConexionDAO<T extends EDVADB> {
	
	private final String driver = "com.mysql.jdbc.Driver";
	private final String database = "jdbc:mysql://localhost/edvadb";
	private final String user = "root";
	private final String pass = "root";
	protected Connection conn = null;
	
	/**
	 * Obtiene una conexión con la base de datos. Se debe llamar a este
	 * método antes de realizar cualquier operación csobre la base de datos
	 * con este objeto.
	 * Si ya se ha iniciado una conexión, el método no hace nada.
	 * 
	 * @throws RuntimeException Si ocurrió un error al conectarse con
	 * la base de datos.
	 */
	public void conectar() {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(database, user, pass);
				System.out.println("Conexión exitosa con la base de datos.");
			} catch (SQLException | ClassNotFoundException e) {
				conn = null;
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Cierra la conexión activa con la base de datos. Se debe llamar a este método
	 * cuando ya no se vayan a realizar operaciones sobre la base de datos con este
	 * objeto. Si no se ha iniciado una conexión, el método no hace nada.
	 * 
	 * @throws RuntimeException Si ocurrió un error al cerrar la conexión con la base
	 * de datos.
	 */
	public void desconectar() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
				System.out.println("Se ha desconectado de la base de datos.");
			} catch (SQLException e) {
				conn = null;
				throw new RuntimeException(e);
			}
		}
	}
	
	/**
	 * Realiza una consulta genérica a la base de datos. Es posible especificar opciones específicas de la
	 * base de datos dentro de la consulta (p.e. el alias de las columnas o el orden de las tuplas). Regresa
	 * una lista de mapas, donde cada mapa es una tupla del ResultSet; para acceder a los valores de las tuplas
	 * se utiliza el nombre (o alias) de la columna. Por ejemplo, se pueden acceder a las tuplas de la siguiente manera:
	 * <br>
	 * <pre><code>
	 * List&lt;Map&lt;String, Object&gt;&gt; tuplas =
	 *   consultaGenerica("SELECT nombre as Estudiante, edad FROM Usuario");
	 * 
	 * String nombre = (String)tuplas.get(0).get("Estudiante");
	 * Integer edad = (Integer)tuplas.get(0).get("edad");
	 * </code></pre>
	 * @param sql La consulta SQL a ejecutar.
	 * @return Una lista de mapas. Si la consulta no encuentra nada regresa una lista vacía.
	 * @throws RuntimeException Si ocurrió un error al ejecutar la consulta.
	 */
	public List<Map<String, Object>> consultaGenerica(String sql) {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			List<Map<String, Object>> tabla = new ArrayList<>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> columna = new HashMap<>();
				
				for (int i = 1; i <= numberOfColumns; i++)
					columna.put(rsmd.getColumnLabel(i), rs.getObject(i));
				
				tabla.add(columna);
			}
			
			return tabla;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Inserta un nuevo registro en la base de datos.
	 * @param registro POJO con los datos a insertar. Debe contener la llave o llaves primarias del
	 * nuevo registro.
	 * @throws RuntimeException Si ocurrió un error al insertar el nuevo registro.
	 */
	public abstract void registrar(T registro);
	
	/**
	 * Modifica el registro existente en la base de datos.
	 * 
	 * @param viejo POJO con los datos del registro a modificar. La llave primaria debe
	 * ser igual a la del registro a modificar.
	 * @param nuevo POJO que incluye los nuevos datos que serán insertados. La llave primaria del
	 * registro puede cambiar.
	 * @throws RuntimeException Si ocurrió un error al modificar el registro.
	 */
	public abstract void modificar(T viejo, T nuevo);
	
	/**
	 * Elimina el registro dado de la base de datos.
	 * 
	 * @param registro POJO con los datos del registro a eliminar. Debe contener la llave primaria del registro.
	 * @throws RuntimeException Si ocurrió un error al eliminar el registro
	 */
	public abstract void eliminar(T registro);
	
	/**
	 * Busca el registro dado en la base de datos y regresa el POJO correspondiente con todos
	 * sus campos llenos.
	 * 
	 * @param registro POJO que contenga la llave o llaves primarias del registro a buscar.
	 * @return Un POJO con los datos del registro. Si el registro no existe, regresa <code>null</code>.
	 * @throws RuntimeException Si ocurrió un error al buscar el registro.
	 */
	public abstract T buscar(T registro);
	
	/**
	 * Busca todos los registros de la relación y los almacena en forma de una lista de POJOs, con todos
	 * sus campos llenos.
	 * 
	 * @return Una lista de POJOs. Si la relación no contiene registros, regresa una lista vacía.
	 * @throws RuntimeException Si ocurrió un error al buscar todos los registros.
	 */
	public abstract List<T> buscarTodos();
}
