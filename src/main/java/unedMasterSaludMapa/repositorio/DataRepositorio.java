package unedMasterSaludMapa.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapa.entidad.*;



@Repository

public interface DataRepositorio extends JpaRepository<Data, Long>{

}
