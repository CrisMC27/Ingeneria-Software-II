package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitudes;
import co.edu.ucentral.tarjetac.exception.ResourceNotFoundException;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service

public class ServicioSolicitudes implements Serializable {

    private ModelMapper modelMapper;
    private final RepositorioSolicitudes repoSoli;

    public List<SolicitudesDto> obtenerSolicitudes() {
        TypeToken<List<SolicitudesDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoSoli.findAll(), typeToken.getType());
    }

    public SolicitudesDto obtenerSolicitud(long serial){
        Solicitudes solicitud = repoSoli.findById(serial).orElseThrow(
                ResourceNotFoundException::new);
        return modelMapper.map(solicitud, SolicitudesDto.class);
    }
}
