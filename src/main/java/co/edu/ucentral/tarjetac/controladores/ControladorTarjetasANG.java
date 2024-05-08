package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.servicios.ServicioTarjetas;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/tarjetas")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET})

public class ControladorTarjetasANG {
        private static final Logger logger = LogManager.getLogger(ControladorTarjetas.class);

    private ServicioTarjetas servicioTarjetas;

    @GetMapping("/todas")
    public ResponseEntity<List<TarjetasDto>> listarTarjetas(){

        return ResponseEntity.ok(servicioTarjetas.obtenerTarjetas());
    }
}
