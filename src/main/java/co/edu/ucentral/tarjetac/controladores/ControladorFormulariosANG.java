package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.servicios.ServicioFormulario;
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
        methods = {RequestMethod.POST})

public class ControladorFormulariosANG {
    private static final Logger logger = LogManager.getLogger(ControladorFormularios.class);


    private ServicioFormulario servicioFormulario;

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FormularioDto> crear(@Validated @RequestBody FormularioDto entityDto) {
        entityDto = servicioFormulario.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

}
