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
import org.springframework.web.bind.annotation.*;
import com.teambravos.pokedex.domain.dto.AuthResponse;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/auth")


/**
 * Controlaor Principal para incio de sesion dentro de la api aqui se validara la informacion
 * de jwt
 *
 *
 * @autor Luis Alberto Vazquez
 * @since 14/01/2021
 */
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PokemonUserService pokemonUserService;
    @Autowired
    private JWUtil jwtUtil;

    @PostMapping("/authenticate")

    public ResponseEntity<AuthResponse> createToken(@RequestBody AuthRequest request){

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = pokemonUserService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthResponse(jwt), HttpStatus.OK);
        }catch(BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
