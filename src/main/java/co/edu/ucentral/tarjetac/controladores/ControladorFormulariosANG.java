package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
import co.edu.ucentral.tarjetac.servicios.ServicioFormulario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ControladorFormulariosANG {
    private static final Logger logger = LogManager.getLogger(ControladorFormularios.class);


    private ServicioFormulario servicioFormulario;
/*
    @GetMapping("/")
    public ResponseEntity<List<FormularioDto>> listarEquipos(){

        return ResponseEntity.ok(servicioFormulario.obtenerEquipos());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<FormularioDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioFormulario.obtenerEquipo(serial));
    }
*/

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FormularioDto> crear(@Validated @RequestBody FormularioDto entityDto) {
        entityDto = servicioFormulario.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    /*
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FormularioDto> modificar(@Validated @RequestBody EquipoDto entityDto) {
        entityDto = servicioFormulario.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioFormulario.eliminar(serial);
    }*/

}
