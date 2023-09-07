package unedMasterJavaModelo;
import java.util.*;
import java.sql.*;

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
	  
	  
	  
