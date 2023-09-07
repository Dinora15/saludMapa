package unedMasterJavaModelo;
import java.sql.*;
import java.util.*;
import unedMasterJavaModelo.Conector;



public class UsuarioDbd {
	
	
	 private static Connection connection;
	 
	  public UsuarioDbd() {
	        connection = Conector.getConnection();
	    }
	    
	  public void crearUsuario(Usuario usuario){
	    	try {
	            PreparedStatement preparedStatement = connection
	                    .prepareStatement("insert into usuario(nombre,clave) values (?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, usuario.getNombre());
	            //preparedStatement.setString(2, usuario.getPassword());

	            preparedStatement.setString(2, usuario.getClave());
	            preparedStatement.executeUpdate();  
	            
	           

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public static List<Usuario> getTodosUsuarios() {
	        List<Usuario> usuarios = new ArrayList<Usuario>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from usuario");
	            while (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setNombre(rs.getNString("nombre"));;
	                usuario.setClave(rs.getString("clave"));
	                usuarios.add(usuario);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return usuarios;
	    }
	  
	  public String getSession(Usuario usuario){
	    	
	    	try{
	    			    		
	    		PreparedStatement user = connection.prepareStatement("select * from usuario where (nombre =? and clave =?)");
	    		 
	    		
	    		 user.setString(1, usuario.getNombre());
	    		 user.setString(2,  usuario.getClave());	    		 
	    		 ResultSet rs = user.executeQuery();
	    		 
	    		 
	    		 if (rs.next()) {
	                 usuario.setNombre(rs.getString("nombre"));
	                 usuario.setClave(rs.getString("clave"));
	                 if(usuario.getNombre().equals("Administrador")){
	                System.out.println("Administrador"); 
	                	 return "ADMINISTRADOR";
	                 }
	                 else{
	                	  System.out.println("Usuario");
	                	 return "USUARIO";
	                 }
	             }else{

	            	 System.out.println("No eres Usuario");
	         		return "NO_USUARIO";
	            	 
	             } 
	    	
	    	
	    }
	    	catch (SQLException e) {
	    		return "Error"+e;
	        }
	    }

}
