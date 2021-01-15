package com.teambravos.pokedex.persistence.mapper;


import com.teambravos.pokedex.domain.service.PokemonI;
import com.teambravos.pokedex.persistence.entity.Pokemon;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.persistence.Column;
import java.util.List;
/**
 * PokemonMapper realiza un mapeo o transformación de las clases Pokemon y PokemonI
 *
 * @author  Valeria Esquivel
 * @since   13-01-2021
 * */
@Mapper(componentModel = "spring")
public interface PokemonMapper {

    /**
     * El metodo toPokemonI recibe un objeto de tipo Pokemon y lo transforma con los Mappings a un objeto de tipo PokemonI
     * @param pokemon
     *
     */
    @Mappings({
            @Mapping(source = "idPokemon",target = "pokemonId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "tipo",target = "type"),
            @Mapping(source = "habilidades",target = "abilities"),
            @Mapping(source = "habilidadesEspeciales",target = "specialAbilities"),
            @Mapping(source = "evolucion",target = "evolution"),
            @Mapping(source = "imagen",target = "image"),





    })
    PokemonI toPokemonI(Pokemon pokemon);



    /**
     * el metodo toPokemons crea una lista de de objetos tipo Pokemon
     * @param pokemones
     *
     */

    List<PokemonI> toPokemons(List<Pokemon> pokemones);

    /**
     * El metodo toPokemon recibe un objeto de tipo PokemonI y
     * lo transforma con @InheritInverseConfiguration a un objeto de tipo Pokemon
     * lo inverso al metodo toPokemonI
     * @param pokemon
     *
     */
    @InheritInverseConfiguration
    Pokemon toPokemon(PokemonI pokemon);



}
