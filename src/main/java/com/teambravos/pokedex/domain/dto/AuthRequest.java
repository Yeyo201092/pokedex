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
    private String Password;

    public String getUsarname() {
        return username;
    }

    public void setUsarname(String usarname) {
        username = usarname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
