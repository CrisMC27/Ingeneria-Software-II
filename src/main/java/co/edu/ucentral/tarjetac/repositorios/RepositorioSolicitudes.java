package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitudes;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioSolicitudes extends CrudRepository<Solicitudes, Long>, JpaSpecificationExecutor<Solicitudes> {
    @Query("SELECT s.SOL_NUMERODESOLICITUD, s.SOL_NOMBRES, s.SOL_APELLIDOS, s.SOL_DOCUMENTO, s.SOL_CORREO, s.SOL_FECHA " +
            "FROM Solicitudes s ORDER BY s.SOL_FECHA DESC" )
    List<Solicitudes> findSolicitudesBy();
}
