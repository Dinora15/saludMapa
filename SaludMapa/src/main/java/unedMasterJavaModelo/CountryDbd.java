package unedMasterJavaModelo;
import java.util.*;
import java.sql.*;

/**
 * Clase CountryDbd: Sirve como intermediario entre la aplicación y la base de datos
 * para operaciones relacionadas con el modelo Country.
 */

public class CountryDbd {
	
	 private Connection connection;
	 private static Connection conn;
	 private static int pagesize = 3;
	 
	 
	 static {
			conn = DbConnection.getConnection();
					
		}
	 
	 public CountryDbd() {
	        connection = Conector.getConnection();
	    }

	/**
	 * Obtiene una lista paginada de países.
	 *
	 * @param pageNo Número de página que se desea obtener.
	 * @return Lista de países para la página solicitada.
	 */
	 
	 public static ArrayList<Country> getCountryList(int pageNo){
		 ArrayList<Country> list = new ArrayList<Country>();
		 int begin = (pageNo-1)*pagesize;
		 int end = pagesize;
		 try {
	            Statement statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM country LIMIT "+begin+ "," +end);
	            while (rs.next()) {
	            	 Country country = new Country("","");
	                 country.setCountry_code(rs.getString("country_code"));
	                 country.setCountry_name(rs.getString("country_name"));
	                 list.add(country);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list; 
	
	 }

	/**
	 * Verifica si un país existe en la base de datos por su código.
	 *
	 * @param country País que se quiere verificar.
	 * @return Verdadero si existe, falso en caso contrario.
	 */
	 
	 public boolean ExisteCountry(Country country) {
	    	Boolean salida = null;
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("select * from country where country_code=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, country.getCountry_code());
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next()) {
	                salida = true;
	            } else {
	            	salida = false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return salida;
	    }

	 
	/**
	 * Añade un nuevo país a la base de datos.
	 *
	 * @param country País que se desea añadir.
  
	 **/
	
	 public void addCountry(Country country) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into country(country_code,country_name) values (?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, country.getCountry_code());
	            preparedStatement.setString(2, country.getCountry_name());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	/**
	 * Elimina un país de la base de datos por su código.
	 *
	 * @param code Código del país que se desea eliminar.
	 */
	 public void deleteCountry(String code) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("delete from country where country_code=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, code);
	            preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	/**
	 * Actualiza los detalles de un país en la base de datos.
	 *
	 * @param country País que se desea actualizar.
	 */
	 public void updateCountry(Country country) {
	        try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("update country set country_name=?" +
	                            "where country_code=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, country.getCountry_name());
	            preparedStatement.setString(2, country.getCountry_code());
	            preparedStatement.executeUpdate();
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	        
	        
	      /**
	 * Obtiene el número total de páginas para paginación.
	 *
	 * @return Número total de páginas.
	 */  
	       
	        public static int getTotalPage() {
	        	int totalCount = 0;
	    		int totalPage = 0;
	    		
	            try {
	                Statement statement = conn.createStatement();
	                ResultSet rs = statement.executeQuery("SELECT count(country_code) from country");
	                if(rs.next()) {
	                	totalCount = rs.getInt(1);
	    				totalPage = (totalCount-1)/pagesize+1;
	                }
	                               
	            } catch (SQLException e) {
	                e.printStackTrace();
	                
	            }

	            return totalPage;
	        }

	 
	 public List<Country> getAllCountry() {
	        List<Country> countries = new ArrayList<Country>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from country");
	            while (rs.next()) {
	                Country country = new Country();
	                country.setCountry_code(rs.getString("country_code"));
	                country.setCountry_name(rs.getString("country_name"));
	                countries.add(country);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countries;
}

	/**
	 * Obtiene un país de la base de datos por su código.
	 *
	 * @param code Código del país que se desea obtener.
	 * @return País correspondiente al código proporcionado.
	 */
	 public Country getCountryByCode(String code) {
	    	Country country = new Country("","");
	        try {
	            PreparedStatement preparedStatement = connection.
	                    prepareStatement("select * from country where country_code=?");
	            preparedStatement.setString(1, country.getCountry_code());
	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                country.setCountry_code(rs.getString("country_code"));
	                country.setCountry_name(rs.getString("country_name"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return country;
	    }

	/**
	 * Obtiene una lista de países de la base de datos filtrados por su código.
	 *
	 * @param countryCode Código del país para filtrar.
	 * @return Lista de países filtrados por código.
	 */
	 
	  public List<Country> getCountry(String countryCode) {
	        List<Country> countries = new ArrayList<Country>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM country WHERE country_code ='"+countryCode+"';");
	            while (rs.next()) {
	                Country country = new Country("","");
	                country.setCountry_code(rs.getString("country_code"));
	                country.setCountry_name(rs.getString("country_name"));
	                countries.add(country);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return countries;
	    }
	  
	 
}
	  
	  
	  
