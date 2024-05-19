package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Tarjeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RepositorioTarjetasTest {

    @Autowired
    RepositorioTarjetas repositorioTarjetas;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("Test de crear Tarjeta")
    @Test
    void testCrearTarjeta() {
        LocalDate fechaVecLocal = LocalDate.of(2024, 12, 31);
        Date fechaVec = Date.from(fechaVecLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Tarjeta tarjeta = Tarjeta
                .builder()
                .serial(32L)
                .numerotarjeta(5432L)
                .fecha_vec(fechaVec)
                .documento(678989)
                .cupo(79870L)
                .fecha_cor(fechaVec)
                .fecha_lim(fechaVec)
                .saldo(7689L)
                .build();

        Tarjeta tarjeta1 = repositorioTarjetas.save(tarjeta);

        assertThat(tarjeta1).isNotNull();
        assertThat(tarjeta1.getSerial()).isGreaterThan(0);
    }

    @DisplayName("Test de listar Tarjeta")
    @Test
    void testListarTarjetas() {
        LocalDate fechaVecLocal = LocalDate.of(2024, 12, 31);
        Date fechaVec = Date.from(fechaVecLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Tarjeta tarjeta1 = Tarjeta
                .builder()
                .numerotarjeta(5432L)
                .fecha_vec(fechaVec)
                .documento(678989)
                .cupo(79870L)
                .fecha_cor(fechaVec)
                .fecha_lim(fechaVec)
                .saldo(7689L)
                .build();

        Tarjeta tarjeta2 = Tarjeta
                .builder()
                .numerotarjeta(5432L)
                .fecha_vec(fechaVec)
                .documento(877893)
                .cupo(67098423L)
                .fecha_cor(fechaVec)
                .fecha_lim(fechaVec)
                .saldo(7689L)
                .build();

        testEntityManager.persist(tarjeta1);
        testEntityManager.persist(tarjeta2);
        testEntityManager.flush();

        List<Tarjeta> tarjetas= (List<Tarjeta>) repositorioTarjetas.findAll();

        assertThat(tarjetas).isNotNull();
        assertThat(tarjetas.size()).isGreaterThan(0);
        assertThat(tarjetas).contains(tarjeta1, tarjeta2);
    }

    @DisplayName("Test de actualizar tarjeta")
    @Test
    void testActualizarTarjeta() {
        LocalDate fechaVecLocal = LocalDate.of(2024, 12, 31);
        Date fechaVec = Date.from(fechaVecLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Tarjeta tarjeta = Tarjeta
                .builder()
                .numerotarjeta(5432L)
                .fecha_vec(fechaVec)
                .documento(678989)
                .cupo(79870L)
                .fecha_cor(fechaVec)
                .fecha_lim(fechaVec)
                .saldo(7689L)
                .build();

        Tarjeta tarjeta1 = testEntityManager.persistAndFlush(tarjeta);

        LocalDate nuevaFecha = LocalDate.of(2023, 11, 3);
        Date nuevaFechaVec = Date.from(nuevaFecha.atStartOfDay(ZoneId.systemDefault()).toInstant());

        tarjeta1.setNumerotarjeta(53276L);
        tarjeta1.setFecha_vec(nuevaFechaVec);
        tarjeta1.setDocumento(78102);
        tarjeta1.setCupo(38902L);
        tarjeta1.setFecha_cor(nuevaFechaVec);
        tarjeta1.setFecha_lim(nuevaFechaVec);
        tarjeta1.setSaldo(78954L);

        Tarjeta tarjetaActualizada = repositorioTarjetas.save(tarjeta1);

        assertThat(tarjetaActualizada).isNotNull();
        assertThat(tarjetaActualizada.getNumerotarjeta()).isEqualTo(53276L);
        assertThat(tarjetaActualizada.getFecha_vec()).isEqualTo(nuevaFechaVec);
        assertThat(tarjetaActualizada.getDocumento()).isEqualTo(78102);
        assertThat(tarjetaActualizada.getCupo()).isEqualTo(38902L);
        assertThat(tarjetaActualizada.getFecha_cor()).isEqualTo(nuevaFechaVec);
        assertThat(tarjetaActualizada.getFecha_lim()).isEqualTo(nuevaFechaVec);
        assertThat(tarjetaActualizada.getSaldo()).isEqualTo(78954L);
    }

    @DisplayName("Test de borrar una tarjeta")
    @Test
    void testBorrarTarjeta() {
        LocalDate fechaVecLocal = LocalDate.of(2024, 12, 31);
        Date fechaVec = Date.from(fechaVecLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Tarjeta tarjeta = Tarjeta
                .builder()
                .numerotarjeta(5432L)
                .fecha_vec(fechaVec)
                .documento(678989)
                .cupo(79870L)
                .fecha_cor(fechaVec)
                .fecha_lim(fechaVec)
                .saldo(7689L)
                .build();

        Tarjeta tarjetaPersistida = testEntityManager.persist(tarjeta);
        testEntityManager.flush();

        repositorioTarjetas.deleteById(tarjetaPersistida.getSerial());
        testEntityManager.flush();

        Tarjeta tarjetaborrada = testEntityManager.find(Tarjeta.class, tarjetaPersistida.getSerial());
        assertThat(tarjetaborrada).isNull();
    }
}
