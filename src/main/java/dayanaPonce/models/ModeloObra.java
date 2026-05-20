package dayanaPonce.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.Year;

@Entity
@Table(name = "obras")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ModeloObra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private Year añoCreacion;
    private String tecnica;
    private int valorEuros;

    @ManyToOne
    @JoinColumn(name = "exposicion_id")
    private ModeloExposicion exposicion;

    //Getters y Setters automaticamente generados por Lombok !!!
}