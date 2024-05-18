package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioSolicitudesTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RepositorioSolicitudes repoSoli;

    @InjectMocks
    private ServicioSolicitudes servicioSolicitudes;

    private List<Solicitud> solicitudList;
    private List<SolicitudesDto> solicitudesDtoList;

    @BeforeEach
    void setUp() {
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
}
