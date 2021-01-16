package com.teambravos.pokedex.domain.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 *Contraseña y usuario para poder accerder a la api
 *
 *
 * @author Luis Alberto
 * @since   16-01-2021
 *
 **/


@Service
public class PokemonUserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("user","{noop}pokemos", new ArrayList<>());
    }
}
