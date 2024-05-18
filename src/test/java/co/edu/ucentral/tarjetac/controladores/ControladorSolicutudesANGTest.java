package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;



@WebMvcTest
class ControladorSolicutudesANGTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioSolicitudes servicioSolicitudes;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Test listar controlador API")
    @Test

    void testListarControladorAPI() throws Exception {
        SolicitudesDto solicitud = SolicitudesDto
                .builder()
                .numerosolicitud(1L)
                .nombre("Cris")
                .apellido("Mar")
                .celular(341314)
                .correo("cm@gmail.com")
                .cedula(34321)
                .salario(692390L)
                .gastos(678075L)
                .build();
        given(servicioSolicitudes.obtenerSolicitudes())
                .willReturn(Collections.singletonList(solicitud));

        ResultActions response = mockMvc.perform(get("/api/solicitudes/all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(solicitud)));

        response.andExpect(status().isOk());
    }
}