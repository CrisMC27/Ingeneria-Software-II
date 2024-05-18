package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ControladorSolicutudesANG.class)
class ControladorSolicutudesANGTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioSolicitudes servicioSolicitudes;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private ControladorSolicutudesANG controladorSolicutudesANG;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test crear solicitud API")
    @Test
    void testCrearSolicitudAPI() throws Exception {
        SolicitudesDto solicitudDto = new SolicitudesDto();
        solicitudDto.setNombre("Juan");
        solicitudDto.setApellido("Perez");
        solicitudDto.setCelular(123456789);
        solicitudDto.setCorreo("juan.perez@example.com");
        solicitudDto.setCedula(987654321);
        solicitudDto.setSalario(5000);
        solicitudDto.setGastos(1000);

        given(servicioSolicitudes.registrar(any(SolicitudesDto.class))).willReturn(solicitudDto);

        ResultActions response = mockMvc.perform(post("/api/solicitudes/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(solicitudDto)));

        response.andExpect(status().isCreated());

        verify(servicioSolicitudes, times(1)).registrar(any(SolicitudesDto.class));
    }


}