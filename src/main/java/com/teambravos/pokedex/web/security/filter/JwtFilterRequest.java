package com.teambravos.pokedex.web.security.filter;

import com.teambravos.pokedex.domain.service.PokemonUserService;
import com.teambravos.pokedex.web.security.JWUtil;
import com.teambravos.pokedex.web.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest  {
/*
    @Autowired
    private JWUtil jwtUtil;

    @Autowired
    private PokemonUserService pokemonUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(jwt);

            if( username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = pokemonUserService.loadUserByUsername(username);


                if(jwtUtil.validateToken(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }

        }

        filterChain.doFilter(request,response);
    }


 */
}
