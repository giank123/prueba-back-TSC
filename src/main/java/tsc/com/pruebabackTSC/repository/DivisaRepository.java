package tsc.com.pruebabackTSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tsc.com.pruebabackTSC.entity.Divisa;

public interface DivisaRepository extends JpaRepository<Divisa, Long> {
    @Query("select (count(d) > 0) from Divisa d")
    boolean existsByNombre();
    Divisa findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
