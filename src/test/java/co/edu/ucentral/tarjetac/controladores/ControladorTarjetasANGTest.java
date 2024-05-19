package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.servicios.ServicioTarjetas;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ControladorTarjetasANG.class)
class ControladorTarjetasANGTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioTarjetas servicioTarjetas;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Test listar controlador API")
    @Test

    void testListarControladorAPI() throws Exception {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaVec = formatoFecha.parse("2024-12-31");
        Date fechaCor = formatoFecha.parse("2024-05-20");
        Date fechaLim = formatoFecha.parse("2024-11-30");

        TarjetasDto tarjetas = TarjetasDto
                .builder()
                .serial(1L)
                .numerotarjeta(34312L)
                .fecha_vec(fechaVec)
                .documento(12321)
                .cupo(3972879L)
                .fecha_cor(fechaCor)
                .fecha_lim(fechaLim)
                .saldo(6778930L)
                .build();

        given(servicioTarjetas.obtenerTarjetas())
                .willReturn(Collections.singletonList(tarjetas));

        ResultActions response = mockMvc.perform(get("/api/tarjetas/todas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(tarjetas)));

        response.andExpect(status().isOk());

    }

}