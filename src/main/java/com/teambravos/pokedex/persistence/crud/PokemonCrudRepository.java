package com.teambravos.pokedex.persistence.crud;

import com.teambravos.pokedex.persistence.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
/**
 * PokemonCrudRepository implementa los metodos de la interfaz CrudRepository
 *
 *
 * @author  Valeria Esquivel
 * @since   13-01-2021
 * */
public interface PokemonCrudRepository extends CrudRepository<Pokemon,Integer> {


}
