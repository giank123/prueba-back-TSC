package tsc.com.pruebabackTSC.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsc.com.pruebabackTSC.security.entity.Rol;
import tsc.com.pruebabackTSC.security.enums.RolNombre;
import tsc.com.pruebabackTSC.security.repository.RolRepository;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
