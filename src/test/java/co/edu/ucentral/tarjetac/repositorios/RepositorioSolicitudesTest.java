package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitud;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
class RepositorioSolicitudesTest {

    @Autowired
    RepositorioSolicitudes repositorioSolicitudes;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("Test de crear solicitud")
    @Test
    void testCrearSolicitudes() {
        Solicitud solicitud = Solicitud.builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453L)
                .gastos(345634L)
                .build();

        Solicitud solicitud1 = repositorioSolicitudes.save(solicitud);

        assertThat(solicitud1).isNotNull();
        assertThat(solicitud1.getNumerosolicitud()).isGreaterThan(0);
    }

    @DisplayName("Test de listar solicitudes")
    @Test
    void testListarSolicitudes() {

        Solicitud solicitud1 = Solicitud.builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453L)
                .gastos(345634L)
                .build();

        Solicitud solicitud2 = Solicitud.builder()
                .nombre("Juan")
                .apellido("Perez")
                .celular(987654321)
                .correo("juanp@gmail.com")
                .cedula(987654321)
                .salario(50000L)
                .gastos(30000L)
                .build();

        testEntityManager.persist(solicitud1);
        testEntityManager.persist(solicitud2);
        testEntityManager.flush();

        List<Solicitud> solicitudes = (List<Solicitud>) repositorioSolicitudes.findAll();

        assertThat(solicitudes).isNotNull();
        assertThat(solicitudes.size()).isGreaterThan(0);
        assertThat(solicitudes).contains(solicitud1, solicitud2);
    }
    @DisplayName("Test de actualizar una solicitud")
    @Test
    void testActualizarSolicitud() {
        Solicitud solicitud = Solicitud.builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453L)
                .gastos(345634L)
                .build();
        Solicitud solicitudPersistida = testEntityManager.persist(solicitud);
        testEntityManager.flush();


        solicitudPersistida.actualizarSolicitud("Juan", "Ponte", 13133, "coreo@gmail.com", 4521432, 575432,63627);
        Solicitud solicitudActualizada = repositorioSolicitudes.save(solicitudPersistida);


        assertThat(solicitudActualizada).isNotNull();
        assertThat(solicitudActualizada.getNombre()).isEqualTo("Juan");
        assertThat(solicitudActualizada.getApellido()).isEqualTo("Ponte");
        assertThat(solicitudActualizada.getCelular()).isEqualTo(13133);
        assertThat(solicitudActualizada.getCorreo()).isEqualTo("coreo@gmail.com");
        assertThat(solicitudActualizada.getCedula()).isEqualTo(4521432);
        assertThat(solicitudActualizada.getSalario()).isEqualTo(575432);
        assertThat(solicitudActualizada.getGastos()).isEqualTo(63627);
    }
    @DisplayName("Test de borrar una solicitud")
    @Test
    void testBorrarSolicitud() {

        Solicitud solicitud = Solicitud.builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453L)
                .gastos(345634L)
                .build();
        Solicitud solicitudPersistida = testEntityManager.persist(solicitud);
        testEntityManager.flush();

        repositorioSolicitudes.deleteById(solicitudPersistida.getNumerosolicitud());
        testEntityManager.flush();


        Solicitud solicitudBorrada = testEntityManager.find(Solicitud.class, solicitudPersistida.getNumerosolicitud());
        assertThat(solicitudBorrada).isNull();
    }
}
