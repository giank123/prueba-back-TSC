package tsc.com.pruebabackTSC.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Cambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double montoOrigen;

    @Column
    private Double montoDestino;

    @Column
    private String monedaOrigen;

    @Column
    private String monedaDestino;

    @Column
    private Double tipoCambio;


    

}
