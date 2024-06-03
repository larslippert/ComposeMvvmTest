package com.laoves.mylittleapp.domain.model.pokemon

import com.laoves.mylittleapp.data.remote.pokemon.dto.Sprites
import com.laoves.mylittleapp.data.remote.pokemon.dto.Stat
import com.laoves.mylittleapp.data.remote.pokemon.dto.Type

data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: PokemonSprites,
    val stats: List<PokemonStat>,
    val types: List<Type>,
    val weight: Int
)
