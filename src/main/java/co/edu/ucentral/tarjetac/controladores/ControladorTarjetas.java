package co.edu.ucentral.tarjetac.controladores;


import co.edu.ucentral.tarjetac.servicios.ServicioTarjetas;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Log4j2
@Controller
public class ControladorTarjetas {
    private static final Logger logger = LogManager.getLogger(ControladorTarjetas.class);

    @Autowired
    ServicioTarjetas servicioTarjetas;

    @GetMapping({"/tarjetas"})
    public String listarTarjetas(Model model) {
        logger.info("Verificando ");
        model.addAttribute("tarjetas", servicioTarjetas.obtenerTarjetas());
        return "tarjetas";

    }
}