package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class ServicioFormulario implements Serializable {

    private ModelMapper modelMapper;
    private final RepositorioSolicitudes repoSoli;

    public FormularioDto registrar(FormularioDto formularioDto) {
        Solicitud laSolicitud = repoSoli.save(modelMapper.map(formularioDto, Solicitud.class));
        return modelMapper.map(laSolicitud, FormularioDto.class);
    }

}
