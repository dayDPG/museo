package dayanaPonce.services;

import dayanaPonce.models.ModeloExposicion;
import dayanaPonce.models.ModeloObra;
import dayanaPonce.repositories.ExposicionRepository;
import dayanaPonce.repositories.ObraRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServicioGeneral {

    private final ObraRepository obraRepo;
    private final ExposicionRepository exposicionRepo;

    public ServicioGeneral(ObraRepository obraRepo, ExposicionRepository exposicionRepo) {
        this.obraRepo = obraRepo;
        this.exposicionRepo = exposicionRepo;
    }

    //OBRAS
    public List<ModeloObra> listarAllObras() {
        return (List<ModeloObra>) obraRepo.findAll();
    }
    public List<ModeloObra> listarAllObras(String titulo, String autor, String tecnica) {
        // por orden de prioridad se lista -> titulo > autor > tecnica
            if (titulo != null && !titulo.isEmpty()) {
                return obraRepo.findByTituloContainingIgnoreCase(titulo);
            }
            if (autor != null && !autor.isEmpty()) {
                return obraRepo.findByAutorContainingIgnoreCase(autor);
            }
            if (tecnica != null && !tecnica.isEmpty()) {
                return obraRepo.findByTecnicaContainingIgnoreCase(tecnica);
            }
            return listarAllObras();
    }
    //-----------------------filtros---------------------------
    public List<ModeloObra> filtrarObrasPorExposicion(Long exposicionId) {
        if (exposicionId != null) {
            return obraRepo.findByExposicionId(exposicionId);
        }
        return listarAllObras();
    }
    //-----------------------filtros---------------------------
    public Optional<ModeloObra> obtenerObraId(Long id) {
        return obraRepo.findById(id);
    }

    public ModeloObra guardarObra(ModeloObra obra) {
        return obraRepo.save(obra);
    }

    public void eliminarObra(Long id) {
        obraRepo.deleteById(id);
    }

    // exposiciones
    public List<ModeloExposicion> listarAllExposiciones() {
        return (List<ModeloExposicion>) exposicionRepo.findAll();
    }

    public List<ModeloExposicion> listarAllExposiciones(String titulo, String ciudad, LocalDate fecha) {
        // por orden de prioridad se lista -> titulo > ciudad > fecha
        if (titulo != null && !titulo.isEmpty()) {
            return filtrarExposTitulo(titulo);
        }
        if (ciudad != null && !ciudad.isEmpty()) {
            return filtrarExposCiudad(ciudad);
        }
        if (fecha != null) {
            return filtrarExposActivas(fecha);
        }
        return listarAllExposiciones();
    }
    //-----------------------filtros---------------------------
    public List<ModeloExposicion> filtrarExposActivas(LocalDate fecha) {
        if (fecha != null) {
            return exposicionRepo.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(fecha, fecha);
        }
        return listarAllExposiciones();
    }

    public List<ModeloExposicion> filtrarExposTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            return exposicionRepo.findByTituloContainingIgnoreCase(titulo);
        }
        return listarAllExposiciones();
    }

    public List<ModeloExposicion> filtrarExposCiudad(String ciudad) {
        if (ciudad != null && !ciudad.isEmpty()) {
            return exposicionRepo.findObrasByCiudadIgnoreCase(ciudad);
        }
        return listarAllExposiciones();
    }
    //-----------------------filtros---------------------------

    public int calcularValorTotalObras(Long exposicionId) {
        List<ModeloObra> obras = filtrarObrasPorExposicion(exposicionId);
        return obras.stream().mapToInt(ModeloObra::getValorEuros).sum();
    }

    public Optional<ModeloExposicion> obtenerExposicionId(Long id) {
        return exposicionRepo.findById(id);
    }

    public ModeloExposicion guardarExposicion(ModeloExposicion exposicion) {
        return exposicionRepo.save(exposicion);
    }

    public void eliminarExposicion(Long id) {
        exposicionRepo.deleteById(id);
    }
}
