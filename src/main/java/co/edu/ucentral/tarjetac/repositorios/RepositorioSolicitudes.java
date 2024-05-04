package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioSolicitudes extends CrudRepository<Solicitud, Long >, JpaSpecificationExecutor<Solicitud> {
    @Query("SELECT s FROM Solicitud s " )
    List<Solicitud> findSolicitudesBy();
}
