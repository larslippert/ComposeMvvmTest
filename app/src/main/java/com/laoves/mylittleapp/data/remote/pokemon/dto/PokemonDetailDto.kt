package com.laoves.mylittleapp.data.remote.pokemon.dto

import com.laoves.mylittleapp.domain.model.pokemon.PokemonDetail
import com.laoves.mylittleapp.domain.model.pokemon.PokemonSprites
import com.laoves.mylittleapp.domain.model.pokemon.PokemonStat

data class PokemonDetailDto(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

fun PokemonDetailDto.toPokemonDetail(): PokemonDetail {
    return PokemonDetail(
        id = id,
        name = name,
        sprites = sprites.toPokemonSprites(),
        stats = stats.map { it.toPokemonStat() },
        types = types,
        weight = weight,
    )
}