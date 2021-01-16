package com.teambravos.pokedex.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWUtil {

<<<<<<< HEAD
    private static final String  KEY = "pokemos";
=======
        private static final String  key= "pokemon";
>>>>>>> 7f54459debb42763fc97cb759d20927c3b88507f

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,KEY ).compact();
    }

    public boolean validateToken( String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

<<<<<<< HEAD
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
=======
        public boolean validarToken(String token, UserDetails userDetails){
            return userDetails.getUsername().equals(extraerUsuario(token)) && !tokenexpirado(token);
        }
>>>>>>> 7f54459debb42763fc97cb759d20927c3b88507f

    public boolean isTokenExpired(String token){
        return  getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }


}
