package unedMasterControlador;

// Importe de las librerias necesarias
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import unedMasterJavaModelo.*;

// Definicion y configuracion del servlet
@WebServlet("/Sesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Instancias para la gestión de datos, usuarios, países e indicadores de salud
   	 private UsuarioDbd dbd;
	 private UsuarioDbd dbd;
	 private DataDbd dataDbd;
	 private CountryDbd countryDbd;
	 private HealthIndicadoresDbd healthIndicadoresDbd;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor
     */
    public InicioSesion() {
        super();
        
        
            dbd = new UsuarioDbd();
            dataDbd = new DataDbd();
            countryDbd = new CountryDbd();
            healthIndicadoresDbd = new HealthIndicadoresDbd();
            
        }

    

	 // Método que maneja las peticiones y respuestas HTTP
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
HttpSession sesion = request.getSession(true); //almaceno la sesion
		
		// Crea un usuario !! HARDCODED
		Usuario user = new Usuario("dinora", "root");
	
		dbd.getSession(user);

		// Recoge los parámetros del formulario para acceder
		String usuarioAcceso = request.getParameter("nombre"); //almaceno el usuario
		response.getWriter().append("\nUSUARIO: " + usuarioAcceso); //visualizao el valor del usuario

		String passAcceso = request.getParameter("clave"); //almaceno el pass
		response.getWriter().append("\nPASSWORD: " + passAcceso); //visualizao el valor del pass

		// Crea un nuevo objeto de tipo usuario
		Usuario usuario = new Usuario();
        	usuario.setNombre(usuarioAcceso);
        	usuario.setClave(passAcceso);

	// Verifica el tipo de usuario
        String tipoUsuario = dbd.getSession(usuario);
       //System.out.println("\nEl tipo de usuario es: " + tipoUsuario);
		
	//Redirige el index si no es un usuario valido a estado1
        if (tipoUsuario.equals("NO_USUARIO")) {
        	response.sendRedirect("index.jsp?estado1");
        } else {
        	
        	
		// Si el uuario es valido, obtiene las diferentes listas y datos		
        	List<Country> listadoPaises = countryDbd.getAllCountry();        	
        	List<HealthIndicadores> listadoIndicadores1 = healthIndicadoresDbd.getAllHealth();
        	List<Data> listadoDatas = dataDbd.getAllData();
        	
        	
        	for (int i = 0; i < listadoPaises.size(); i++) {
        		
        	}
        	
        	sesion.setAttribute("listaPaises",listadoPaises);
		
        	
        	
		
        	
        	for (int i = 0; i < listadoIndicadores1.size(); i++) {
        		
        	}
        	//añadimos como atributo el objeto con el arraylist de los indicadores
        	sesion.setAttribute("listadoIndicadores1",listadoIndicadores1);
        	
        	//Iteramos el arraylist de datas
        	//System.out.println("Using for loop for listadoData:");
        	for (int i = 0; i < listadoDatas.size(); i++) {
        		//Iteramos el arraylist de datas
        		//System.out.println("LISTADATAS: " + listadoDatas.get(i).toString());
        	}
        	//añadimos como atributo el objeto con el arraylist de los datas
        	sesion.setAttribute("listaDatas",listadoDatas);
		
        	
        	response.sendRedirect("menu.jsp?estado=1");
        	
        }
        
        
        sesion.setAttribute("usuarioAcceso",usuarioAcceso);
      
	}

		
		
	}
