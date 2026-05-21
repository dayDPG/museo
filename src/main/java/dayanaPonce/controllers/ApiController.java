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

    //EXPOSICIONES
    @GetMapping("/exposiciones")
    public List<ModeloExposicion> listarExposiciones(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return servicio.listarAllExposiciones(titulo, ciudad, fecha);
    }

    @GetMapping("/exposiciones/{id}")
    public ResponseEntity<ModeloExposicion> obtenerExposicion(@PathVariable Long id) {
        return servicio.obtenerExposicionId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/exposiciones")
    public ResponseEntity<ModeloExposicion> crearExposicion(@RequestBody ModeloExposicion exposicion) {
        return ResponseEntity.ok(servicio.guardarExposicion(exposicion));
    }

    @PutMapping("/exposiciones/{id}")
    public ResponseEntity<ModeloExposicion> actualizarExposicion(
            @PathVariable Long id, @RequestBody ModeloExposicion datos) {
        return servicio.obtenerExposicionId(id).map(existente -> {
            existente.setTitulo(datos.getTitulo());
            existente.setCiudad(datos.getCiudad());
            existente.setFechaInicio(datos.getFechaInicio());
            existente.setFechaFin(datos.getFechaFin());
            return ResponseEntity.ok(servicio.guardarExposicion(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/exposiciones/{id}")
    public ResponseEntity<Void> eliminarExposicion(@PathVariable Long id) {
        if (servicio.obtenerExposicionId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        servicio.eliminarExposicion(id);
        return ResponseEntity.noContent().build();
    }

    //OBRASS
    @GetMapping("/obras")
    public List<ModeloObra> listarObras(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String tecnica) {
        return servicio.listarAllObras(titulo, autor, tecnica);
    }

    @GetMapping("/obras/{id}")
    public ResponseEntity<ModeloObra> obtenerObra(@PathVariable Long id) {
        return servicio.obtenerObraId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/obras")
    public ResponseEntity<ModeloObra> crearObra(@RequestBody ModeloObra obra) {
        return ResponseEntity.ok(servicio.guardarObra(obra));
    }

    @PutMapping("/obras/{id}")
    public ResponseEntity<ModeloObra> actualizarObra(
            @PathVariable Long id, @RequestBody ModeloObra datos) {
        return servicio.obtenerObraId(id).map(existente -> {
            existente.setTitulo(datos.getTitulo());
            existente.setAutor(datos.getAutor());
            existente.setAñoCreacion(datos.getAñoCreacion());
            existente.setTecnica(datos.getTecnica());
            existente.setValorEuros(datos.getValorEuros());
            existente.setExposicion(datos.getExposicion());
            return ResponseEntity.ok(servicio.guardarObra(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/obras/{id}")
    public ResponseEntity<Void> eliminarObra(@PathVariable Long id) {
        if (servicio.obtenerObraId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        servicio.eliminarObra(id);
        return ResponseEntity.noContent().build();
    }
}
