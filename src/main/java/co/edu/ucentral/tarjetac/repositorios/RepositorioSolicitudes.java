package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioSolicitudes extends JpaRepository<Solicitudes, Long>, JpaSpecificationExecutor<Solicitudes> {

}

