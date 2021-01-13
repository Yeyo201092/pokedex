package com.teambravos.pokedex.persistence.crud;

import com.teambravos.pokedex.persistence.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonCrudRepository extends CrudRepository<Pokemon,Integer> {


}
