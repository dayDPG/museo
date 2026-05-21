package dayanaPonce.repositories;

import dayanaPonce.models.ModeloObra;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.time.Year;

public interface ObraRepository extends CrudRepository<ModeloObra, Long> {
    List<ModeloObra> findByTituloContainingIgnoreCase(String titulo);
    List<ModeloObra> findByAutorContainingIgnoreCase(String autor);
    List<ModeloObra> findByAñoCreacion(Year añoCreacion);
    List<ModeloObra> findByTecnicaContainingIgnoreCase(String tecnica); //Se le poone el ContainingIgnoreCase
                                                                        // asi se puede hacer una mejor busqueda la vd
    List<ModeloObra> findByExposicionId(Long exposicionId);
}