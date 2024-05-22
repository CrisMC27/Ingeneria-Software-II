package co.edu.ucentral.tarjetac.servicios;


import co.edu.ucentral.tarjetac.dto.PagosDto;
import co.edu.ucentral.tarjetac.entidades.Pago;
import co.edu.ucentral.tarjetac.repositorios.RepositorioPagos;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;


@AllArgsConstructor
@Service

public class ServicioPagos implements Serializable {

    private ModelMapper modelMapper;
    private final RepositorioPagos repoPago;

    public PagosDto registrar(PagosDto pagosDto) {
        Pago pago = repoPago.save(modelMapper.map(pagosDto, Pago.class));
        return modelMapper.map(pago, PagosDto.class);
    }
}
