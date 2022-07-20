package tsc.com.pruebabackTSC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tsc.com.pruebabackTSC.dto.Mensaje;
import tsc.com.pruebabackTSC.entity.Cambio;
import tsc.com.pruebabackTSC.entity.Divisa;
import tsc.com.pruebabackTSC.service.DivisaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("tata/api")
public class DivisaController {

    @Autowired
    private DivisaService divisaService;

    @GetMapping("/divisa")
    public ResponseEntity<List<Divisa>> listarDivisas() {
        return  new ResponseEntity<>(divisaService.listarDivisas(), HttpStatus.OK);
    }

    @GetMapping("/divisa/{id}")
    public ResponseEntity<Divisa> obtenerDivisaPorId(@PathVariable("id") Long id) {
        if(!divisaService.existsById(id))
             return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Divisa divisa = divisaService.getOne(id).get();
        return  new ResponseEntity<>(divisa, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/divisa")
    public ResponseEntity<Divisa> registrarDivisa(@RequestBody Divisa request) {
        return  new ResponseEntity<>(divisaService.registrarDivisa(request), HttpStatus.OK);
    }


    @PostMapping(value = "/cambio", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public ResponseEntity<Cambio> registrarCambio(@RequestBody Cambio request) {
        return new ResponseEntity<>(divisaService.registrarCambio(request), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/divisa")
    public ResponseEntity<Divisa> updateCurrency(@RequestBody Divisa request) {
        return new ResponseEntity<>(divisaService.updateDivisa(request), HttpStatus.OK);
    }

}
