package unedMasterJavaModelo;

public class Usuario {
	
	private String nombre;
	private String clave;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}





	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", clave=" + clave +  "]";
	}


	}


