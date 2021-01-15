package com.teambravos.pokedex.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWUtil {

        private static final String  key= "pokemon";


        public String generateToken(UserDetails userDetails){
            return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                    .setExpiration(new Date (System.currentTimeMillis()+1000*60*60*10))
                    .signWith(SignatureAlgorithm.HS256, key).compact();
        }

        public boolean validarToken(String token, UserDetails userDetails){
            return userDetails.getUsername().equals(extraerUsuario(token)) && !tokenexpirado(token);
        }


        public String extraerUsuario(String token){
            return getClaims(token).getSubject();
        }

        public boolean tokenexpirado(String token){
            return getClaims(token).getExpiration().before(new Date());
        }

        private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        }



}
