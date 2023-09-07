package unedMasterJavaModelo;
import java.util.*;
import java.sql.*;
import unedMasterJavaModelo.*;

public class HealthIndicadoresDbd {
	
	private Connection connection;
	private static Connection conn;
	 private static int pagesize = 3;
	 
	 
	 static {
			conn = DbConnection.getConnection();
					
		}

	    public HealthIndicadoresDbd() {
	        connection = Conector.getConnection();
	    }

	    public static ArrayList<HealthIndicadores> getHealthIndicadoresList(int pageNo){
			 ArrayList<HealthIndicadores> list = new ArrayList<HealthIndicadores>();
			 int begin = (pageNo-1)*pagesize;
			 int end = pagesize;
			 try {
		            Statement statement = conn.createStatement();
		            ResultSet rs = statement.executeQuery("SELECT * FROM healthindicadores LIMIT "+begin+ "," +end);
		            while (rs.next()) {
		            	 HealthIndicadores healthindicadores = new HealthIndicadores("","","","");
		                 healthindicadores.setIndicadores_code(rs.getString("indicador_code"));
		                 healthindicadores.setIndicadores_name(rs.getString("indicador_name"));
		                 healthindicadores.setSource_note(rs.getString("source_nota"));
		                 healthindicadores.setSource_organization(rs.getString("source_organization"));
		                 list.add(healthindicadores);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return list; 
		
		 }
	    
	    public static int getTotalPage() {
       	int totalCount = 0;
   		int totalPage = 0;
   		
           try {
               Statement statement = conn.createStatement();
               ResultSet rs = statement.executeQuery("SELECT count(indicador_code) from healthindicadores");
               if(rs.next()) {
               	totalCount = rs.getInt(1);
   				totalPage = (totalCount-1)/pagesize+1;
               }
                              
           } catch (SQLException e) {
               e.printStackTrace();
               
           }

           return totalPage;
       }
	    

   
    
    public void addHealthIndicadores(HealthIndicadores healthIndicadores) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into healthindicadores(indicador_code,indicador_name, source_nota, source_organization) values (?, ?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, healthIndicadores.getIndicadores_code());
            preparedStatement.setString(2, healthIndicadores.getIndicadores_name());
            preparedStatement.setString(3, healthIndicadores.getSource_note());
            preparedStatement.setString(4, healthIndicadores.getSource_organization());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteHealthIndicador(String code) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from healthindicadores where indicador_code=?");
            // Parameters start with 1
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateHealthIndicadores(HealthIndicadores healthIndicadores) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update healthindicadores set indicador_name=?" + "source_nota=?"+"source_organization=?"+
                            "where indicador_code=?");
            // Parameters start with 1
            preparedStatement.setString(1, healthIndicadores.getIndicadores_name());
            preparedStatement.setString(2, healthIndicadores.getIndicadores_code());
            preparedStatement.setString(3, healthIndicadores.getSource_note());
            preparedStatement.setString(4, healthIndicadores.getSource_organization());
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<HealthIndicadores> getAllHealth() {
        List<HealthIndicadores> Indicadores = new ArrayList<HealthIndicadores>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from healthindicadores");
            while (rs.next()) {
            	HealthIndicadores Indicadores1 = new HealthIndicadores();
            	Indicadores1.setIndicadores_code(rs.getString("indicador_code"));
            	Indicadores1.setIndicadores_name(rs.getString("indicador_name"));
            	Indicadores1.setSource_note(rs.getString("source_nota"));
            	Indicadores1.setSource_organization(rs.getString("source_organization"));
            	
            	Indicadores.add(Indicadores1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Indicadores;
    }
    
    public HealthIndicadores getHealthIndicadoresByCode(String code) {
    	HealthIndicadores healthIndicadores = new HealthIndicadores();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from healthindicadores where indicador_code=?");
            preparedStatement.setString(1, code);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	healthIndicadores.setIndicadores_code(rs.getString("indicador_code"));
            	healthIndicadores.setIndicadores_name(rs.getString("indicador_name"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return healthIndicadores;
    }
    
   

}
