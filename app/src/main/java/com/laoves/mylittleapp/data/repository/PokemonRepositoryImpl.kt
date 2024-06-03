package com.laoves.mylittleapp.data.repository

import com.laoves.mylittleapp.data.remote.pokemon.PokemonApi
import com.laoves.mylittleapp.data.remote.pokemon.dto.PokemonDetailDto
import com.laoves.mylittleapp.domain.repository.PokemonRepository

class PokemonRepositoryImpl(private val api: PokemonApi): PokemonRepository {
    override suspend fun getPokemonById(pokemonId: String): PokemonDetailDto {
        return api.getPokemonById(pokemonId)
    }
}