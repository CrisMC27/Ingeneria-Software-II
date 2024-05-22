package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.entidades.Tarjeta;
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
    public TarjetasDto obtenerTarjetasByNum(long numT) {
        TypeToken<List<TarjetasDto>> typeToken = new TypeToken<>(){};
        List<Tarjeta> listaT = repotarj.findTarjetasByNumT(numT);
        if(!listaT.isEmpty())
            return modelMapper.map(listaT.get(0), typeToken.getType());
        return null;
    }
    public List<TarjetasDto> updateTarjetas(TarjetasDto, tarjeta) {
        TypeToken<List<TarjetasDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repotarj.findTarjetasBy(), typeToken.getType());
    }

}
