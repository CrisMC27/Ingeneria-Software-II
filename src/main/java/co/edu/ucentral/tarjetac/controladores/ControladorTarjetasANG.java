package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.servicios.ServicioTarjetas;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/tarjetas")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ControladorTarjetasANG {

    private ServicioTarjetas servicioTarjetas;

    @GetMapping("/todas")
    public ResponseEntity<List<TarjetasDto>> listarTarjetas(){

        return ResponseEntity.ok(servicioTarjetas.obtenerTarjetas());
    }
    @GetMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TarjetasDto> registrarTarjeta(@Validated @RequestBody TarjetasDto entityDto){
        entityDto = servicioTarjetas.registrar(entityDto);
        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
}
