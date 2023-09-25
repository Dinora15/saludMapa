package unedMasterJavaModelo;
import java.util.*;
import java.sql.*;

/**
 * Clase DataDbd: Se encarga de realizar operaciones con la base de datos relacionadas con la clase Data.
 */

public class DataDbd {
	
	 private Connection connection;
	 private static Connection conn;
	 private static int pagesize = 3;
	 
	 
	 static {
			conn = DbConnection.getConnection();
					
		}

	    public DataDbd() {
	        connection = Conector.getConnection();
	    }

	 /**
     * Obtiene una lista de objetos Data para una página específica.
     * @param pageNo Número de página.
     * @return Lista de datos para la página especificada.
     */

	    public static ArrayList<Data> getDataList(int pageNo){
			 ArrayList<Data> list = new ArrayList<Data>();
			 int begin = (pageNo-1)*pagesize;
			 int end = pagesize;
			 try {
		            Statement statement = conn.createStatement();
		            ResultSet rs = statement.executeQuery("SELECT * FROM data LIMIT "+begin+ "," +end);
		            while (rs.next()) {
		            	 Data data = new Data("","","");
		                 data.setIndicador_code(rs.getString("indicador_code"));
		                 data.setCountry_code(rs.getString("country_code"));
		                 data.setYear(rs.getString("year"));
		                 list.add(data);
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
                ResultSet rs = statement.executeQuery("SELECT count(country_code) from data");
                if(rs.next()) {
                	totalCount = rs.getInt(1);
    				totalPage = (totalCount-1)/pagesize+1;
                }
                               
            } catch (SQLException e) {
                e.printStackTrace();
                
            }

            return totalPage;
        }
	    
	    public List<Data> getAllData() {
	        List<Data> datas = new ArrayList<Data>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from data;");
	            while (rs.next()) {
	            	Data data = new Data();
	            	data.setIndicador_code(rs.getString("indicador_code"));
	            	data.setCountry_code(rs.getString("country_code"));
	            	data.setYear(rs.getString("year"));
	            	datas.add(data);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return datas;
	    }
	    
	    
	    
	    public List<Data> getDataPaginacion(int pag, int numeroFilas) {
	        List<Data> datas = new ArrayList<Data>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from data limit "+numeroFilas+" OFFSET "+pag*numeroFilas+";");
	            while (rs.next()) {
	            	Data data = new Data();
	            	data.setIndicador_code(rs.getString("indicador_code"));
	            	data.setCountry_code(rs.getString("country_code"));
	            	data.setYear(rs.getString("year"));
	            	datas.add(data);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return datas;
	    }
	    
	    
	    public int getNumeroPaginas() {
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS total FROM data;");
	            rs.next();
	            return rs.getInt("total");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return 0;
	        }
	        
	    }

	        public List<Data> getDataIndicadorCountry(String indicadorCode, String countryCode) {
	            List<Data> datas = new ArrayList<Data>();
	            try {
	                Statement statement = connection.createStatement();
	                ResultSet rs = statement.executeQuery(("SELECT * FROM data WHERE country_code = '"+countryCode+"' AND indicador_code ='"+indicadorCode+"';"));
	                while (rs.next()) {
	                	Data data = new Data();
	                	data.setIndicador_code(rs.getString("indicador_code"));
	                	data.setCountry_code(rs.getString("country_code"));
	                	data.setYear(rs.getString("year"));
	                	datas.add(data);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            return datas;
	        }
	        
	        
	        public void deleteData( String code, String indicador, String year) {
	            try {
	                PreparedStatement preparedStatement = connection
	                        .prepareStatement("delete from data where indicador_code=? and country_code=? and year=?");
	                preparedStatement.setString(1, indicador);
	                preparedStatement.setString(2, code);
	                preparedStatement.setString(3, year);
	                preparedStatement.executeUpdate();

	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        public Data getOneData(String indicador, String code, String year) {
	        	Data data = new Data();
	    	    if(indicador != null && code != null && year != null){    
	        		try {
	    	            PreparedStatement preparedStatement = connection
	    	                    .prepareStatement("SELECT * FROM data WHERE indicador_code=? and country_code=? and year=?");
	    	            // Parameters start with 1
	    	            preparedStatement.setString(1, indicador);
	    	            preparedStatement.setString(2, code);
	    	            preparedStatement.setString(3, year);
	    	            ResultSet rs = preparedStatement.executeQuery();
	    	            
	    	            while (rs.next()) {
	    	            	data.setIndicador_code(rs.getString("indicador_code"));
	    	            	data.setCountry_code(rs.getString("country_code"));
	    	            	data.setYear(rs.getString("year"));
	    	            	
	    	            }
	    	            
	    	
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	        }
	        		return data;
	    	    }
	    	    return new Data("indicador", "country", "2017");   
	        }
	        
	        
	        public void createData(Data data) {
	            try {
	            	
	                PreparedStatement preparedStatement = connection
	                        .prepareStatement("insert into data(country_code, indicador_code, year) values (?, ?, ? )");
	                
	                
	                preparedStatement.setString(1, data.getCountry_code());
	                preparedStatement.setString(2, data.getIndicador_code());
	                preparedStatement.setString(3, data.getYear());
	                preparedStatement.executeUpdate();
	                
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } 
	        
	        public void updateData(Data data) {
	            try {
	            	
	                PreparedStatement preparedStatement = connection
	                        .prepareStatement("update data set percentage=?" +
	                                "where indicador_code=? and country_code=? and year=?");

	                
	                preparedStatement.setString(1, data.getIndicador_code());
	                preparedStatement.setString(2, data.getCountry_code());
	                preparedStatement.setString(3, data.getYear());
	                preparedStatement.executeUpdate();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

