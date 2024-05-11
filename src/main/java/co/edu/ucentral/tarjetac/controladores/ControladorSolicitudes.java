package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.servicios.ServicioSolicitudes;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller

public class ControladorSolicitudes {
    private static final Logger logger = LogManager.getLogger(ControladorSolicitudes.class);

    @Autowired
    ServicioSolicitudes servicioSolicitudes;
    @GetMapping("/formularios/nuevo")
    public String mostrarFormulario(Model model){
        SolicitudesDto solicitudesDto = new SolicitudesDto();
        model.addAttribute("formulario", solicitudesDto);
        return "crear_formulario";
    }
    @PostMapping("/formularios")
    public String registrarEquipo(@ModelAttribute("formulario") SolicitudesDto formulario) {
        servicioSolicitudes.registrar(formulario);
        return "redirect:/formularios";
    }

}
