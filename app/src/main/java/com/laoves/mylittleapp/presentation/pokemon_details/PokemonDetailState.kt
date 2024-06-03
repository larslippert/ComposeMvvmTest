package com.laoves.mylittleapp.presentation.pokemon_details

import com.laoves.mylittleapp.domain.model.pokemon.PokemonDetail

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: PokemonDetail? = null,
    val error: String = ""
)