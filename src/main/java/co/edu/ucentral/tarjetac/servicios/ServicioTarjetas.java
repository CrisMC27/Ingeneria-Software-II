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
    public TarjetasDto registrar(TarjetasDto tarjetasDto){
        Tarjeta tarjeta = repotarj.save(modelMapper.map(tarjetasDto, Tarjeta.class));
        return modelMapper.map(tarjeta, TarjetasDto.class);
    }
    public TarjetasDto obtenerTarjetasByNum(long numT) {
        List<Tarjeta> listaT = repotarj.findTarjetasByNumT(numT);
        if(!listaT.isEmpty())
            return modelMapper.map(listaT.get(0), TarjetasDto.class);
        return null;
    }

    public TarjetasDto actualizarTarjeta(TarjetasDto tarjetaDto) {
        Tarjeta tarjeta = modelMapper.map(tarjetaDto, Tarjeta.class);
        repotarj.save(tarjeta);
        return modelMapper.map(tarjeta, TarjetasDto.class);
    }
}