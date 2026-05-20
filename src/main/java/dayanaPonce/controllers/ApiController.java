package dayanaPonce.controllers;

import dayanaPonce.models.ModeloExposicion;
import dayanaPonce.models.ModeloObra;
import dayanaPonce.services.ServicioGeneral;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ServicioGeneral servicio;
    public ApiController(ServicioGeneral service) {
        this.servicio = service;
    }

    //GET EXPOSICIONES
    @GetMapping("/exposiciones")
    public List<ModeloExposicion> listarExposiciones(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return servicio.listarAllExposiciones(titulo, ciudad, fecha);
    }

    //GET OBRAS
    @GetMapping("/obras")
    public List<ModeloObra> listarObras(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String tecnica) {
        return servicio.listarAllObras(titulo, autor, tecnica);
    }

    //POST expos
    @PostMapping("/exposiciones")
    public ResponseEntity<ModeloExposicion> crearExposicion(@RequestBody ModeloExposicion exposicion) {
        // Aquí podrías agregar lógica para guardar la exposición usando el servicio
        // Por ejemplo: servicio.guardarExposicion(exposicion);
        return ResponseEntity.ok(exposicion); // Devuelve la exposición creada (simulada)
    }





}
