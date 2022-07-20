package tsc.com.pruebabackTSC.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "divisa")
public class Divisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MONEDAORIGEN")
    private String monedaOrigen;

    @Column(name = "MONEDADESTINO")
    private String monedaDestino;

    @Column(name = "TIPOCAMBIO")
    private Double tipoCambio;


}
