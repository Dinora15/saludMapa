package unedMasterJavaModelo;
import java.sql.*;

public class Conector {

	private static Connection connection = null;

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
