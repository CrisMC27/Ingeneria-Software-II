package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.repositorios.RepositorioTarjetas;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service

public class ServicioTarjetas implements Serializable {
    private ModelMapper modelMapper;
    private final RepositorioTarjetas repotarj;

    public List<TarjetasDto> obtenerTarjetas() {
        TypeToken<List<TarjetasDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repotarj.findTarjetasBy(), typeToken.getType());
    }
}
