package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})


public class ControladorSolicutudesANG {

    private ServicioSolicitudes servicioSolicitudes;

    @GetMapping("/all")
    public ResponseEntity<List<SolicitudesDto>> listarSolicitudesAll() {

        return ResponseEntity.ok(servicioSolicitudes.obtenerSolicitudes());
    }

    @GetMapping("/{numerosolicitud}")
    public ResponseEntity<SolicitudesDto> obtenerPorId(@PathVariable("numerosolicitud") Long numerosolicitud) {
        return ResponseEntity.ok(servicioSolicitudes.obtenerSolicitudByNum(numerosolicitud));
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SolicitudesDto> crear(@Validated @RequestBody SolicitudesDto entityDto) {
        entityDto = servicioSolicitudes.registrar(entityDto);
        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SolicitudesDto> modificar(@Validated @RequestBody SolicitudesDto entityDto) {
        entityDto = servicioSolicitudes.actualizarSolicitud(entityDto);
        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @PostMapping("/crear-tarjeta/{numerosolicitud}")
    public ResponseEntity<SolicitudesDto> crearTarjeta(@PathVariable("numerosolicitud") Long numerosolicitud) {
        SolicitudesDto solicitud = servicioSolicitudes.obtenerSolicitudByNum(numerosolicitud);
        if (solicitud == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        solicitud = servicioSolicitudes.actualizarSolicitud(solicitud);
        return new ResponseEntity<>(solicitud, HttpStatus.CREATED);
    }

    @DeleteMapping("/{numerosolicitud}")
    public ResponseEntity<Void> eliminar(@PathVariable("numerosolicitud") Long numerosolicitud) {
        try {
            servicioSolicitudes.eliminarSolicitud(numerosolicitud);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
