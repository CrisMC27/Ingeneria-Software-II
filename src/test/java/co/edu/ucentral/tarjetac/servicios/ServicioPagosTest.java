package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.PagosDto;
import co.edu.ucentral.tarjetac.entidades.Pago;
import co.edu.ucentral.tarjetac.repositorios.RepositorioPagos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServicioPagosTest {

    @InjectMocks
    private ServicioPagos servicioPagos;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private RepositorioPagos repopago;

    private List<Pago> pagoList;
    private  List<PagosDto> pagosDtoList;

    @BeforeEach
    void setUp() {

        Pago pago1 = new Pago();
        Pago pago2 = new Pago();
        pagoList = Arrays.asList(pago1, pago2);

        PagosDto pagosDto1 = new PagosDto();
        PagosDto pagosDto2 = new PagosDto();
        pagosDtoList = Arrays.asList(pagosDto1, pagosDto2);
    }

    @Test
    void testRegistar(){
        PagosDto pagosDto = new PagosDto();
        pagosDto.setMonto(958L);
        pagosDto.setNumerotar(63L);

        Pago pago = new Pago();
        pago.setMonto(958L);
        pago.setNumerotar(63L);

        when(modelMapper.map(any(PagosDto.class), eq(Pago.class))).thenReturn(pago);
        when(repopago.save(any(Pago.class))).thenReturn(pago);
        when(modelMapper.map(any(Pago.class), eq(PagosDto.class))).thenReturn(pagosDto);

        PagosDto result = servicioPagos.registrar(pagosDto);

        assertEquals(pagosDto, result);

        verify(modelMapper, times(1)).map(any(PagosDto.class), eq(Pago.class));
        verify(repopago, times(1)).save(any(Pago.class));
        verify(modelMapper, times(1)).map(any(Pago.class), eq(PagosDto.class));
    }

}