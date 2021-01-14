package com.teambravos.pokedex.web.controller;

import com.teambravos.pokedex.domain.dto.AuthRequest;
import com.teambravos.pokedex.domain.service.PokemonUserService;
import com.teambravos.pokedex.web.security.JWUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teambravos.pokedex.domain.dto.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PokemonUserService pokemonUserService;

    @Autowired
    private JWUtil jwUtil;


    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest request){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsarname(),request.getPassword()));
            UserDetails userDetails = pokemonUserService.loadUserByUsername(request.getUsarname());
            String jwt= jwUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthResponse(jwt), HttpStatus.OK);

        }catch(BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}