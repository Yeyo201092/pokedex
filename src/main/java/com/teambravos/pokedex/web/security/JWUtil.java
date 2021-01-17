package com.teambravos.pokedex.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

/**
 * La clase JWTutil Funcionara como generador de de el jwt para su posteriror uso dentro de la api
 *
 *
 * @Author Luis alberto Vazquez
 * @since 14/01/2021
 */
public class JWUtil {


    private static final String  KEY = "pokemos";


    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,KEY ).compact();
    }

    public boolean validateToken( String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }


    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }




    public boolean isTokenExpired(String token){
        return  getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }


}
