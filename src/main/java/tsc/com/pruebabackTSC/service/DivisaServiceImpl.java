package tsc.com.pruebabackTSC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsc.com.pruebabackTSC.entity.Cambio;
import tsc.com.pruebabackTSC.entity.Divisa;
import tsc.com.pruebabackTSC.repository.CambioRepository;
import tsc.com.pruebabackTSC.repository.DivisaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DivisaServiceImpl implements DivisaService {

    @Autowired
    private DivisaRepository divisaRepository;

    @Autowired
    private CambioRepository cambioRepository;

    @Override
    public List<Divisa> listarDivisas() {
        return divisaRepository.findAll();
    }

    @Override
    public Optional<Divisa> getOne(Long id) {
            return divisaRepository.findById(id);
    }

    @Override
    public Divisa registrarDivisa(Divisa request) {
        Divisa divisa= Divisa.builder()
                .monedaOrigen(request.getMonedaOrigen())
                .monedaDestino(request.getMonedaDestino())
                .tipoCambio(request.getTipoCambio())
                .build();
        return divisaRepository.save(divisa);
    }

    @Override
    public Cambio registrarCambio(Cambio request) {

            Divisa divisa = divisaRepository
                    .findByMonedaOrigenAndMonedaDestino(request.getMonedaOrigen(), request.getMonedaDestino());

            Double montoDestino = request.getMontoOrigen() * divisa.getTipoCambio();

            request.setTipoCambio(divisa.getTipoCambio());
            request.setMontoDestino(montoDestino);

        return cambioRepository.save(request);

    }

    @Override
    public Divisa updateDivisa(Divisa request) {
         Divisa divisa = divisaRepository.findById(request.getId()).get();

        divisa.setTipoCambio(request.getTipoCambio());

        return divisaRepository.save(divisa);
    }

    @Override
    public boolean existsById(Long id) {
        return divisaRepository.existsById(id);
    }
}
