package com.teambravos.pokedex.domain.service;


import com.teambravos.pokedex.persistence.crud.UsuarioCrudRepository;
import com.teambravos.pokedex.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PokemonUserService implements UserDetailsService {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> userDb = usuarioCrudRepository.findByUsuario(username);
        if (userDb.isPresent()) {
            Usuario user = userDb.get();
            return new User(username,"{noop}"+user.getContraseña(), new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("Usuario no encontrado!");
        }

    }
}
