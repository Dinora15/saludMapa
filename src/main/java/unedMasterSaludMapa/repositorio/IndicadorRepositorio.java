package unedMasterSaludMapa.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unedMasterSaludMapa.entidad.Indicador;

@Repository
public interface IndicadorRepositorio extends JpaRepository<Indicador, Long>{

}
