package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;




public class ControladorSolicutudesANGTest {

    @InjectMocks
    private ControladorSolicutudesANG controladorSolicutudesANG;

    @Mock
    private ServicioSolicitudes servicioSolicitudes;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrear() {
        SolicitudesDto solicitudDto = new SolicitudesDto();
        solicitudDto.setNombre("Juan");
        solicitudDto.setApellido("Perez");
        solicitudDto.setCelular(123456789);
        solicitudDto.setCorreo("juan.perez@example.com");
        solicitudDto.setCedula(987654321);
        solicitudDto.setSalario(5000);
        solicitudDto.setGastos(1000);

        when(servicioSolicitudes.registrar(any(SolicitudesDto.class))).thenReturn(solicitudDto);

        ResponseEntity<SolicitudesDto> response = controladorSolicutudesANG.crear(solicitudDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(solicitudDto, response.getBody());

        verify(servicioSolicitudes, times(1)).registrar(any(SolicitudesDto.class));
    }
}