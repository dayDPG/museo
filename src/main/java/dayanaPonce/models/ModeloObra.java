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
    private int valorEuros; //Lo dejo en int pq,a lo mejor me equivoco, pero es usual redondeanrlo al valor mas cercano
                            //en especial cuando es solo la estimacion del valor de la obra
                            //(aparte q me di cuenta al final)
                                //---- en todo caso usar BigDecimal, asi es un mejor uso de los decimales----

    @ManyToOne
    @JoinColumn(name = "exposicion_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ModeloExposicion exposicion;

    //Getters y Setters automaticamente generados por Lombok !!!
}