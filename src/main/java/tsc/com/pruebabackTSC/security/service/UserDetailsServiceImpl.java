package tsc.com.pruebabackTSC.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tsc.com.pruebabackTSC.security.entity.Usuario;
import tsc.com.pruebabackTSC.security.entity.UsuarioPrincipal;

//Convierte la clase Usuario en un Usuario Principal
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    //Obtiene un usuario d ela BD y lo convierte en un usuario principal
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}
