package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.PagosDto;
import co.edu.ucentral.tarjetac.servicios.ServicioPagos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ControladorPagosANG.class)
class ControladorPagosANGTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioPagos servicioPagos;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Test crear solicitud API")
    @Test
    void testCrearSolicitudAPI() throws Exception {
        PagosDto pagosDto = new PagosDto();
        pagosDto.setMonto(13L);
        pagosDto.setNumerotar(45L);

        given(servicioPagos.registrar(any(PagosDto.class))).willReturn(pagosDto);

        ResultActions response = mockMvc.perform(post("/api/pagos/pagar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(pagosDto)));

        response.andExpect(status().isCreated());

        verify(servicioPagos, times(1)).registrar(any(PagosDto.class));
    }

}