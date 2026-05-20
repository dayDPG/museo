package dayanaPonce.controllers;

import dayanaPonce.models.ModeloExposicion;
import dayanaPonce.models.ModeloObra;
import dayanaPonce.services.ServicioGeneral;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/web")
public class WebController {

    private final ServicioGeneral servicio;

    public WebController(ServicioGeneral service) {
        this.servicio = service;
    }

    @GetMapping
    public String inicio() {
        return "redirect:/web/exposiciones";
    }

    // --- EXPOSICIONES ---
    @GetMapping("/exposiciones")
    public String listarExposiciones(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            Model model) {
        model.addAttribute("exposiciones", servicio.listarAllExposiciones(titulo, ciudad, fecha));
        model.addAttribute("titulo", titulo);
        model.addAttribute("ciudad", ciudad);
        model.addAttribute("fecha", fecha);
        return "exposiciones/lista";
    }

    @GetMapping("/exposiciones/nueva")
    public String crearExposicion(Model model) {
        model.addAttribute("exposicion", new ModeloExposicion());
        return "exposiciones/formulario";
    }

    @PostMapping("/exposiciones/nueva")
    public String guardarExposicion(@ModelAttribute ModeloExposicion exposicion) {
        servicio.guardarExposicion(exposicion);
        return "redirect:/web/exposiciones";
    }

    @GetMapping("/exposiciones/editar/{id}")
    public String editarExposicion(@PathVariable Long id, Model model) {
        servicio.obtenerExposicionId(id).ifPresent(exposicion -> model.addAttribute("exposicion", exposicion));
        return "exposiciones/formulario";
    }

    @PostMapping("/exposiciones/editar/{id}")
    public String actualizarExposicion(@PathVariable Long id, @ModelAttribute ModeloExposicion exposicion) {
        servicio.obtenerExposicionId(id).ifPresent(existente -> {
            existente.setTitulo(exposicion.getTitulo());
            existente.setCiudad(exposicion.getCiudad());
            existente.setFechaInicio(exposicion.getFechaInicio());
            existente.setFechaFin(exposicion.getFechaFin());
            servicio.guardarExposicion(existente);
        });
        return "redirect:/web/exposiciones";
    }

    @PostMapping("/exposiciones/borrar/{id}")
    public String borrarExposicion(@PathVariable Long id) {
        servicio.eliminarExposicion(id);
        return "redirect:/web/exposiciones";
    }

    @GetMapping("/exposiciones/{id}")
    public String detalleExposicion(@PathVariable Long id, Model model) {
        servicio.obtenerExposicionId(id).ifPresent(exposicion -> {
            model.addAttribute("exposicion", exposicion);
            model.addAttribute("obras", servicio.listarAllObras(null, null, null));
            model.addAttribute("valorTotal", servicio.calcularValorTotalObras(id));
        });
        return "exposiciones/detalle";
    }

    // --- OBRAS ---
    @GetMapping("/obras")
    public String listarObras(@RequestParam(required = false) String tecnica, Model model) {
        model.addAttribute("obras", servicio.listarAllObras(null, null, tecnica));
        model.addAttribute("tecnica", tecnica);
        return "obras/lista";
    }

    @GetMapping("/obras/nueva")
    public String crearObra(Model model) {
        model.addAttribute("obra", new ModeloObra());
        model.addAttribute("exposiciones", servicio.listarAllExposiciones());
        return "obras/formulario";
    }

    @PostMapping("/obras/nueva")
    public String guardarObra(@ModelAttribute ModeloObra obra) {
        servicio.guardarObra(obra);
        return "redirect:/web/obras";
    }

    @GetMapping("/obras/editar/{id}")
    public String editarObra(@PathVariable Long id, Model model) {
        servicio.obtenerObraId(id).ifPresent(obra -> {
            model.addAttribute("obra", obra);
            model.addAttribute("exposiciones", servicio.listarAllExposiciones());
        });
        return "obras/formulario";
    }

    @PostMapping("/obras/editar/{id}")
    public String actualizarObra(@PathVariable Long id, @ModelAttribute ModeloObra obra) {
        servicio.obtenerObraId(id).ifPresent(existente -> {
            existente.setTitulo(obra.getTitulo());
            existente.setAutor(obra.getAutor());
            existente.setAñoCreacion(obra.getAñoCreacion());
            existente.setTecnica(obra.getTecnica());
            existente.setValorEuros(obra.getValorEuros());
            existente.setExposicion(obra.getExposicion());
            servicio.guardarObra(existente);
        });
        return "redirect:/web/obras";
    }

    @PostMapping("/obras/borrar/{id}")
    public String borrarObra(@PathVariable Long id) {
        servicio.eliminarObra(id);
        return "redirect:/web/obras";
    }
}
