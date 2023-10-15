package unedMasterSaludMapa.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControler {

	
@GetMapping("/administrador")
	
	public String iniciarSesion() {
	
	  return "administrador";
	}
}

