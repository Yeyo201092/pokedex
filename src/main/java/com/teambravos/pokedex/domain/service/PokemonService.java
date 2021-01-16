package com.teambravos.pokedex.domain.service;

import com.teambravos.pokedex.domain.repository.PokemonRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepositoryI pokemonRepository;

    @GetMapping("/all")
    public List<PokemonI> getAll() {

        return pokemonRepository.getAll();

    }



    public Optional<PokemonI> getPokemon(int pokemonId) {
        return pokemonRepository.getPokemon(pokemonId);
    }

    public PokemonI save(PokemonI pokemon) {
        return pokemonRepository.save(pokemon);
    }



    public boolean delete(int pokemonId) {
        return getPokemon(pokemonId).map(pokemon ->
        {
            pokemonRepository.delete(pokemonId);
            return true;
        }).orElse(false);
    }


}
