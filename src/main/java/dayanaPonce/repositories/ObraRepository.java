package dayanaPonce.repositories;

import dayanaPonce.models.ModeloObra;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.time.Year;

public interface ObraRepository extends CrudRepository<ModeloObra, Long> {
    List<ModeloObra> findByTituloContainingIgnoreCase(String titulo);
    List<ModeloObra> findByAutorContainingIgnoreCase(String autor);
    List<ModeloObra> findByAñoCreacion(Year añoCreacion);
    List<ModeloObra> findByTecnicaIgnoreCase(String tecnica);
    List<ModeloObra> findByExposicionId(Long exposicionId);
}