package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@AllArgsConstructor
@Service
public class ServicioSolicitudes implements Serializable {

    private ModelMapper modelMapper;
    private final RepositorioSolicitudes repoSoli;

    public SolicitudesDto registrar(SolicitudesDto solicitudesDto) {
        Solicitud laSolicitud = repoSoli.save(modelMapper.map(solicitudesDto, Solicitud.class));
        return modelMapper.map(laSolicitud, SolicitudesDto.class);
    }

}
