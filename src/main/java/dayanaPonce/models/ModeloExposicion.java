package dayanaPonce.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "exposiciones")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ModeloExposicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ciudad; //Cambie sala por ciudad, ya que se podria
                            // filtrar mejor asi 

    @OneToMany(mappedBy = "exposicion", cascade = CascadeType.ALL)
    private List<ModeloObra> obras;

    //Getters y Setters automáticamente generados por Lombok !!!
}
