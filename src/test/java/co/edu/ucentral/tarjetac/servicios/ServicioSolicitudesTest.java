package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicioSolicitudesTest {

    @InjectMocks
    private ServicioSolicitudes servicioSolicitudes;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RepositorioSolicitudes repoSoli;

    private List<Solicitud> solicitudList;
    private List<SolicitudesDto> solicitudesDtoList;

    @BeforeEach
    public void setUp() {
        // Initialize mock data
        Solicitud solicitud1 = new Solicitud();
        Solicitud solicitud2 = new Solicitud();
        solicitudList = Arrays.asList(solicitud1, solicitud2);

        SolicitudesDto solicitudesDto1 = new SolicitudesDto();
        SolicitudesDto solicitudesDto2 = new SolicitudesDto();
        solicitudesDtoList = Arrays.asList(solicitudesDto1, solicitudesDto2);
    }

    @Test
    void obtenerSolicitudesTest() {
        // Mock the behavior of repoSoli.findSolicitudesBy()
        when(repoSoli.findSolicitudesBy()).thenReturn(solicitudList);

        // Mock the behavior of modelMapper.map()
        Type listType = new TypeToken<List<SolicitudesDto>>() {}.getType();
        when(modelMapper.map(solicitudList, listType)).thenReturn(solicitudesDtoList);

        // Call the service method
        List<SolicitudesDto> result = servicioSolicitudes.obtenerSolicitudes();

        // Validate the result
        assertEquals(solicitudesDtoList, result);
    }

    @Test
    void testRegistrar() {
        SolicitudesDto solicitudDto = new SolicitudesDto();
        solicitudDto.setNombre("Juan");
        solicitudDto.setApellido("Perez");
        solicitudDto.setCelular(123456789);
        solicitudDto.setCorreo("juan.perez@example.com");
        solicitudDto.setCedula(987654321);
        solicitudDto.setSalario(5000);
        solicitudDto.setGastos(1000);

        Solicitud solicitud = new Solicitud();
        solicitud.setNombre("Juan");
        solicitud.setApellido("Perez");
        solicitud.setCelular(123456789);
        solicitud.setCorreo("juan.perez@example.com");
        solicitud.setCedula(987654321);
        solicitud.setSalario(5000);
        solicitud.setGastos(1000);

        when(modelMapper.map(any(SolicitudesDto.class), eq(Solicitud.class))).thenReturn(solicitud);
        when(repoSoli.save(any(Solicitud.class))).thenReturn(solicitud);
        when(modelMapper.map(any(Solicitud.class), eq(SolicitudesDto.class))).thenReturn(solicitudDto);

        SolicitudesDto result = servicioSolicitudes.registrar(solicitudDto);

        assertEquals(solicitudDto, result);

        verify(modelMapper, times(1)).map(any(SolicitudesDto.class), eq(Solicitud.class));
        verify(repoSoli, times(1)).save(any(Solicitud.class));
        verify(modelMapper, times(1)).map(any(Solicitud.class), eq(SolicitudesDto.class));
    }
}
