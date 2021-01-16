package com.teambravos.pokedex.web.controller;


import com.teambravos.pokedex.domain.service.PokemonI;
import com.teambravos.pokedex.domain.service.PokemonService;
import com.teambravos.pokedex.persistence.entity.Pokemon;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonContoller {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/all")
    @ApiOperation("Get All Pockemons")
    @ApiResponse(code=200,message= "ok")
    public ResponseEntity<List<PokemonI>> getAll() {
        return new ResponseEntity<>(pokemonService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Pokemon with an Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok"),
            @ApiResponse(code = 404,message = "Pokemon Not Found"),
    })
    private ResponseEntity<PokemonI> getPokemon(@PathVariable("id") int pokemonId){
        return pokemonService.getPokemon(pokemonId)
                .map(pokemon -> new ResponseEntity<>(pokemon,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("Delete a Pokemon with an Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "ok"),
            @ApiResponse(code = 404,message = "Pokemon Not Found"),
    })
    public ResponseEntity delete(@PathVariable("id") int pokemonId){
        if(pokemonService.delete(pokemonId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

<<<<<<< HEAD
    @PostMapping("/save")
    public  ResponseEntity<PokemonI> save(@RequestBody PokemonI pokemonI){
        return new ResponseEntity<>(pokemonService.save(pokemonI), HttpStatus.CREATED);

    }


    @GetMapping("/act/{id}")
    public ResponseEntity<PokemonI>update(@PathVariable ("id")int pokemonid, @RequestBody PokemonI pokemonI){
       return pokemonService.getPokemon(pokemonid)
               .map(pokemonI1 -> new ResponseEntity<>(pokemonService.save(pokemonI),HttpStatus.OK))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
=======

    @PostMapping("/save")
    @ApiOperation("Delete a Pokemon with an Id")
    @ApiResponse(code = 201,message = "created")
    public ResponseEntity<PokemonI> save(@RequestBody PokemonI pokemon) {
        return new ResponseEntity<>(pokemonService.save(pokemon), HttpStatus.CREATED);
>>>>>>> 7f54459debb42763fc97cb759d20927c3b88507f
    }
}


