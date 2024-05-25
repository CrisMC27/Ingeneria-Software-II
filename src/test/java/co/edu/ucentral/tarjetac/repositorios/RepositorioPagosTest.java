package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Pago;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class RepositorioPagosTest {

    @Autowired
    RepositorioPagos repositorioPagos;

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("Test de crear pago")
    @Test
    void testCrearPago() {
        Pago pago = Pago
                .builder()
                .serial(1L)
                .monto(23L)
                .numerotar(42L)
                .build();

        Pago pago1 = repositorioPagos.save(pago);

        assertThat(pago1).isNotNull();
        assertThat(pago1.getSerial()).isGreaterThan(0);
    }

    @DisplayName("Test de listar pagos")
    @Test
    void testListarPagos() {
        Pago pago1 = Pago
                .builder()
                .monto(23L)
                .numerotar(42L)
                .build();
        Pago pago2 = Pago
                .builder()
                .monto(233L)
                .numerotar(4342L)
                .build();

        testEntityManager.persist(pago1);
        testEntityManager.persist(pago2);
        testEntityManager.flush();

        List<Pago> pagos = (List<Pago>) repositorioPagos.findAll();

        assertThat(pagos).isNotNull();
        assertThat(pagos.size()).isGreaterThan(0);
        assertThat(pagos).contains(pago1, pago2);
    }

    @DisplayName("Test de actualizar pago")
    @Test
    void testActualizarPago() {
        Pago pago = Pago
                .builder()
                .monto(23L)
                .numerotar(42L)
                .build();

        Pago pago1 = repositorioPagos.save(pago);

        pago.setMonto(24L);
        pago.setNumerotar(43L);

        Pago pago2 = repositorioPagos.save(pago);

        assertThat(pago2).isNotNull();
        assertThat(pago2.getMonto()).isEqualTo(24L);
        assertThat(pago2.getNumerotar()).isEqualTo(43L);

    }

    @DisplayName("Test de borrar pago")
    @Test
    void testBorrarPago() {

        Pago pago = Pago
                .builder()
                .monto(23L)
                .numerotar(42L)
                .build();

        Pago pago1 = testEntityManager.persist(pago);
        testEntityManager.flush();

        repositorioPagos.deleteById(pago.getSerial());
        testEntityManager.flush();

        Pago pago2 = testEntityManager.find(Pago.class, pago.getSerial());
        assertThat(pago2).isNull();
    }

}