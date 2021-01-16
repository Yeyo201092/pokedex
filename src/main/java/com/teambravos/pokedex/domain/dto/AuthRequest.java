package com.teambravos.pokedex.domain.dto;


/**
 * AuthRequest se usara como medio para guardar nuestro usuario y cotraseña
 *
 *
 * @author  Luis Alberto
 * @since   14-01-2021
 * */


public class AuthRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
