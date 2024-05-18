package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ServicioSolicitudesTest {


    @InjectMocks
    private ServicioSolicitudes servicioSolicitudes;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RepositorioSolicitudes repoSoli;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrar() {
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
        when(modelMapper.map(any(Solicitud.class), eq(SolicitudesDto.class))).thenReturn(solicitudDto);
        when(repoSoli.save(any(Solicitud.class))).thenReturn(solicitud);

        SolicitudesDto result = servicioSolicitudes.registrar(solicitudDto);

        assertEquals(solicitudDto, result);

        verify(modelMapper, times(1)).map(any(SolicitudesDto.class), eq(Solicitud.class));
        verify(repoSoli, times(1)).save(any(Solicitud.class));
        verify(modelMapper, times(1)).map(any(Solicitud.class), eq(SolicitudesDto.class));
    }
}
