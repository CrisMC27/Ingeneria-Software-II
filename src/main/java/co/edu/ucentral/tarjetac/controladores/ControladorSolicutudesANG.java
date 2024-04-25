package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET})

public class ControladorSolicutudesANG {
    private static final Logger logger = LogManager.getLogger(ControladorSolicitudes.class);

    private ServicioSolicitudes servicioSolicitudes;

    @GetMapping("/")
    public ResponseEntity<List<SolicitudesDto>> listarSolicitudes(){

        return ResponseEntity.ok(servicioSolicitudes.obtenerSolicitudes());
    }
    @GetMapping("/all")
    public ResponseEntity<List<SolicitudesDto>> listarSolicitudesAll(){

        return ResponseEntity.ok(servicioSolicitudes.obtenerSolicitudes());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<SolicitudesDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioSolicitudes.obtenerSolicitud(serial));
    }
}