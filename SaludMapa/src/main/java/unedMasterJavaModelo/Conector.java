package unedMasterJavaModelo;
import java.sql.*;

/**
 * Clase Conector: Se encarga de establecer y proporcionar una conexión con la base de datos.
 */
public class Conector {

	// Instancia de conexión. Es estática para garantizar una única conexión durante toda la ejecución del programa.
	private static Connection connection = null;

/**
 * Método para obtener la conexión con la base de datos.
 * Si ya existe una conexión, simplemente la devuelve.
 * Si no existe, intenta establecer una nueva conexión.
*/

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_map", "root", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
