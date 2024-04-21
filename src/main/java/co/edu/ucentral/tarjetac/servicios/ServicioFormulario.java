package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
import co.edu.ucentral.tarjetac.entidades.Solicitudes;
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
public class ServicioFormulario implements Serializable {


    private ModelMapper modelMapper;

    private final RepositorioSolicitudes repoSoli;

    public FormularioDto registrar(FormularioDto formularioDto) {

        Solicitudes laSolicitud = repoSoli.save(modelMapper.map(formularioDto, Solicitudes.class));
        return modelMapper.map(laSolicitud, FormularioDto.class);
    }
    public List<FormularioDto> obtenerEquipos() {
        TypeToken<List<FormularioDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoSoli.findAll(), typeToken.getType());

    }/*
    public FormularioDto obtenerEquipo(long serial) {
        Solicitudes equipo = repoSoli.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(equipo, FormularioDto.class);

    }/*
    public EquipoDto actualizar(EquipoDto equipoDto) {
        repoSoli.save(modelMapper.map(equipoDto, Equipo.class));
        return equipoDto;

    }
    public void eliminar(long serial) {

        repoEquipo.deleteById(serial);


    }*/
}
