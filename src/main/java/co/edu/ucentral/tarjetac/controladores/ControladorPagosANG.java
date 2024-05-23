package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.PagosDto;
import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.servicios.ServicioPagos;
import co.edu.ucentral.tarjetac.servicios.ServicioTarjetas;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.POST})

public class ControladorPagosANG {

    private ServicioPagos servicioPagos;
    private ServicioTarjetas servicioTarjetas;

    @PostMapping("/pagar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PagosDto> crear(@Validated @RequestBody PagosDto entityDto) {
        entityDto = servicioPagos.registrar(entityDto);
        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
}
