package com.teambravos.pokedex.domain.dto;


/**
 *AuthResponse Sera un medio por donde almacenaremos nuestra clave JWT
 *
 *
 * @author  Luis Alberto
 * @since   14/01/2021
 *  */


public class AuthResponse {
    private String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
