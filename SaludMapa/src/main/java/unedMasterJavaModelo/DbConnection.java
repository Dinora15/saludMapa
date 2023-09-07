package unedMasterJavaModelo;
import java.sql.*;
import unedMasterJavaModelo.*;


public class DbConnection {
	
private static Connection conn=null;
private String driver="com.mysql.jdbc.Driver";
private String url="jdbc:mysql://localhost:3306/health_map";
private String user="root";
private String password="";


private DbConnection() throws SQLException {
	
try{
Class.forName(driver);
conn=DriverManager.getConnection(url, user, password);
	
	
}catch(ClassNotFoundException e) {
	
	e.printStackTrace();
}
}

public static Connection getConnection() {
	
	if(conn==null) {
		try {
			new DbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return conn;
}
}
