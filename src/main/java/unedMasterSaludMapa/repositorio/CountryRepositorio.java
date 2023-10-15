package unedMasterSaludMapa.repositorio;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapa.entidad.country;



@Repository
public interface CountryRepositorio extends JpaRepository<country, Long>{

	
	

}
