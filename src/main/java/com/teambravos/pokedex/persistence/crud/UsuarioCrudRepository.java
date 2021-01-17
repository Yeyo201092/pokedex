package com.teambravos.pokedex.persistence.crud;

import com.teambravos.pokedex.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * UsuarioCrudRepository implementa el metodo para buscar un usuario segun su username
 *
 *
 * @author  Valeria Esquivel
 * @since   16-01-2021
 * */
@Repository
public interface UsuarioCrudRepository extends JpaRepository<Usuario,Long> {
    
        Optional<Usuario> findByUsuario(String usuario);
}
