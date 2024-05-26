package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioSolicitudes extends CrudRepository<Solicitud, Long >, JpaSpecificationExecutor<Solicitud> {
    @Query("SELECT s FROM Solicitud s " )
    List<Solicitud> findSolicitudesBy();
    @Query("SELECT s FROM Solicitud s WHERE s.numerosolicitud = :numSolicitud")
    List<Solicitud> findSolicitudesByNumS(long numSolicitud);
}
