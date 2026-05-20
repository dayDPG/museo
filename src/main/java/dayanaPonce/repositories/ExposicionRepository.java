package dayanaPonce.repositories;

import dayanaPonce.models.ModeloExposicion;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.time.LocalDate;

public interface ExposicionRepository extends CrudRepository<ModeloExposicion, Long> {
    List<ModeloExposicion> findByTituloContainingIgnoreCase(String titulo);
    List<ModeloExposicion> findObrasByFechaInicio(LocalDate fechaInicio);
    List<ModeloExposicion> findObrasByFechaFin(LocalDate fechaFin);
    List<ModeloExposicion> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(LocalDate fechainicio, LocalDate fechaFin);
    List<ModeloExposicion> findObrasByCiudadIgnoreCase(String ciudad);    
}