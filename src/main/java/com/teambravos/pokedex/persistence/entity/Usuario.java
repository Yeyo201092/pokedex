package com.teambravos.pokedex.persistence.entity;

import javax.persistence.*;
/**
 *
 * Usuario es la entidad principal utilizada para el login de la aplicacion
 *
 *
 * @author valeria Esquivel
 * @since   16-01-2021
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer idUsuario;
    private String usuario;
    private String contraseña;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
