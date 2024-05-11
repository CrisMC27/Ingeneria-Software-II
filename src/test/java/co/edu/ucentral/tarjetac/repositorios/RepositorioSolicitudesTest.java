package co.edu.ucentral.tarjetac.repositorios;

import co.edu.ucentral.tarjetac.entidades.Solicitud;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest

class RepositorioSolicitudesTest {

    @Autowired
    RepositorioSolicitudes repositorioSolicitudes;

    @Autowired
    TestEntityManager testEntityManager;
    @DisplayName("Test de crear solicitud")
    @Test

    void testCrearSolicitudes() {

        Solicitud solicitud = Solicitud
                .builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453)
                .gastos(345634)
                .build();

        Solicitud solicitud1 = repositorioSolicitudes.save(solicitud);

        assertThat(solicitud1).isNotNull();
        assertThat(solicitud1.getNumerosolicitud()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Test de obtener todas las solicitudes")

    void testObtenerSolicitudes() {
        Solicitud solicitud = Solicitud
                .builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453)
                .gastos(345634)
                .build();

        Solicitud solicitud1 = Solicitud
                .builder()
                .nombre("Samir")
                .apellido("Gaez")
                .celular(1237777770)
                .correo("correo2@gmail.com")
                .cedula(1233333890)
                .salario(4344353)
                .gastos(34563214)
                .build();

        Iterable<Solicitud> iterableSolicitudes = repositorioSolicitudes.findAll();
        List<Solicitud> listasolicitudes = new ArrayList<>();
        iterableSolicitudes.forEach(listasolicitudes::add);

        assertThat(listasolicitudes).isNotNull();
        assertThat(listasolicitudes.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test de actualizar solicitud")

    void testActualizarSolicitud() {
        Solicitud solicitud = Solicitud
                .builder()
                .nombre("Kelly")
                .apellido("Importa")
                .celular(1234567890)
                .correo("correo@gmail.com")
                .cedula(1234567890)
                .salario(43453)
                .gastos(345634)
                .build();

        Solicitud solicitudsave = repositorioSolicitudes.save(solicitud);
        solicitudsave.setNombre("Samir");

        Solicitud solicitudupdate = repositorioSolicitudes.save(solicitudsave);
        Solicitud solicitudRecuperada = repositorioSolicitudes.findById(solicitudupdate.getNumerosolicitud());

        assertThat(solicitudRecuperada).isNotNull();
        assertThat(solicitudRecuperada.getNombre()).isEqualTo("Samir");
    }
}