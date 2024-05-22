package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Tarjeta;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioTarjetas extends CrudRepository<Tarjeta, Long >, JpaSpecificationExecutor<Tarjeta>{
    @Query("SELECT t FROM Tarjeta t " )
    List<Tarjeta> findTarjetasBy();
    @Query("SELECT t FROM Tarjeta t where t.numerotarjeta =:numTarjeta" )
    List<Tarjeta> findTarjetasByNumT(long numTarjeta);


}
