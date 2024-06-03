package com.laoves.mylittleapp.data.remote.pokemon

import com.laoves.mylittleapp.data.remote.pokemon.dto.PokemonDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("v2/pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") pokemonId: String
    ): PokemonDetailDto
}