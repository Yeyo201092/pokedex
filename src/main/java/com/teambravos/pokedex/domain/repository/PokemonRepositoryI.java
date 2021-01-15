package com.teambravos.pokedex.domain.repository;

import com.teambravos.pokedex.domain.service.PokemonI;

import java.util.List;
import java.util.Optional;


/**
 * PokemonRepositoryI crea los métodos necesarios para hacer el CRUD de Pokemon
 *
 * @author  Valeria Esquivel
 * @since   13-01-2021
 * */
public interface PokemonRepositoryI {
    /**
     * Crea el método  para enlistar los objetos de tipo pokemonI
     * @return Una lista de objetos de tipo PokemonI
     */
    List<PokemonI> getAll();

    /**
     * Crea el método  para traer un objeto de tipo pokemonI
     * @param pokemonId
     * @return Objeto de tipo PokemonI
     */
    Optional<PokemonI> getPokemon(int pokemonId);

    /**
     * Crea el método  para guardar un objeto de tipo pokemonI
     * @param pokemon
     * @return Objeto de tipo PokemonI
     */
    PokemonI save (PokemonI pokemon);

    /**
     * Crea el método  para eliminar un objeto de tipo pokemonI
     * @param pokemonId
     */
    void delete(int pokemonId);
}
