package tsc.com.pruebabackTSC.service;

import tsc.com.pruebabackTSC.entity.Cambio;
import tsc.com.pruebabackTSC.entity.Divisa;

import java.util.List;
import java.util.Optional;

public interface DivisaService {
    List<Divisa> listarDivisas();
    Optional<Divisa> getOne(Long id);

    Divisa registrarDivisa(Divisa request);
    Cambio registrarCambio(Cambio request);
    Divisa updateDivisa(Divisa request);

    boolean existsById(Long id);
}
