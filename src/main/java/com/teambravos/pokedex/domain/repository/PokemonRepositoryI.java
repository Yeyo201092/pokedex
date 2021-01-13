package com.teambravos.pokedex.domain.repository;

import com.teambravos.pokedex.domain.service.PokemonI;

import java.util.List;
import java.util.Optional;

public interface PokemonRepositoryI {
    List<PokemonI> getAll();
    Optional<PokemonI> getPokemon(int pokemonId);
    PokemonI save (PokemonI pokemon);
    void delete(int pokemonId);
}
