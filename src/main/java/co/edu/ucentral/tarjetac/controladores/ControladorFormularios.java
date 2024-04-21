package co.edu.ucentral.tarjetac.controladores;

import co.edu.ucentral.tarjetac.dto.FormularioDto;
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
public class ControladorFormularios{
    private static final Logger logger = LogManager.getLogger(ControladorFormularios.class);

    @Autowired
    ServicioFormulario servicioFormulario;
/*
    @GetMapping({  "/formularios"})
    public String listarFormularios(Model model){
        logger.info("Verificando ");
        model.addAttribute("Formularios",servicioFormulario.obtenerEquipos());
        return "formularios";
    }*/
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

/*
    @GetMapping("/equipos/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", servicioEquipos.obtenerEquipo(serial));
        return "editar_equipo";
    }

    @PostMapping("/equipos/{serial}")
    public String modificarEquipo(@PathVariable long serial,@ModelAttribute( "equipo") EquipoDto equipoDto, Model model){


        model.addAttribute("equipo", servicioEquipos.actualizar(equipoDto));
        return "redirect:/equipos";
    }
    @GetMapping("/equipos/{serial}")
    public String eliminarEquipo(@PathVariable long serial){

        servicioEquipos.eliminar(serial);

        return "redirect:/equipos";
    }*/
}
