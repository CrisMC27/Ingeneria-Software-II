package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.entidades.Tarjeta;
import co.edu.ucentral.tarjetac.repositorios.RepositorioTarjetas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicioTarjetasTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RepositorioTarjetas repotarj;

    @InjectMocks
    private ServicioTarjetas servicioTarjetas;

    private List<Tarjeta> tarjetaList;
    private List<TarjetasDto>tarjetasDtoList;

    @BeforeEach
    void setUp() {
        Tarjeta tarjeta1 = new Tarjeta();
        Tarjeta tarjeta2 = new Tarjeta();
        tarjetaList = Arrays.asList(tarjeta1, tarjeta2);

        TarjetasDto tarjetasDto1 = new TarjetasDto();
        TarjetasDto tarjetasDto2 = new TarjetasDto();
        tarjetasDtoList =Arrays.asList(tarjetasDto1, tarjetasDto2);
    }

    @Test
    void obtenerTarjetas() {

        when(repotarj.findTarjetasBy()).thenReturn(tarjetaList);

        Type listType = new TypeToken<List<TarjetasDto>>() {}.getType();
        when(modelMapper.map(tarjetaList, listType)).thenReturn(tarjetasDtoList);

        List<TarjetasDto> result = servicioTarjetas.obtenerTarjetas();
        assertEquals(tarjetasDtoList, result);
    }
}