package com.laoves.mylittleapp.domain.repository

import com.laoves.mylittleapp.data.remote.pokemon.dto.PokemonDetailDto

interface PokemonRepository {

    suspend fun getPokemonById(pokemonId: String): PokemonDetailDto
}