package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
import co.edu.ucentral.tarjetac.entidades.Solicitudes;
import co.edu.ucentral.tarjetac.servicios.ServicioFormulario;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RestController
@RequestMapping("/api")
public class ControladorFormularios{
    private static final Logger logger = LogManager.getLogger(ControladorFormularios.class);

    @Autowired
    ServicioFormulario servicioFormulario;
    @GetMapping("/solicitudes")
    public List<Solicitudes> listarSolicitudes(){
        logger.info("Listando todas las solicitudes");
        return servicioFormulario.obtenerSolicitud();
    }
    @GetMapping({  "/formularios"})
    public String listarFormularios(Model model){
        logger.info("Verificando ");
        model.addAttribute("Formularios",servicioFormulario.obtenerSolicitud());
        return "formularios";
    }
    @GetMapping("/formularios/nuevo")
    public String mostrarFormulario(Model model){
        FormularioDto formularioDto = new FormularioDto();
        model.addAttribute("formulario", formularioDto);
        return "crear_formulario";
    }
    @PostMapping("/formularios")
    public String registrarEquipo(@ModelAttribute("formulari") FormularioDto formulario) {
        servicioFormulario.registrar(formulario);
        return "redirect:/formularios";
    }

}
