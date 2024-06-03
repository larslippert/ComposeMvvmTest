package com.laoves.mylittleapp.data.remote.pokemon.dto

import com.google.gson.annotations.SerializedName
import com.laoves.mylittleapp.domain.model.pokemon.PokemonSprites

data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    @SerializedName("front_default")
    val frontDefault: String,
    val front_female: Any,
    @SerializedName("front_shiny")
    val frontShiny: String,
    val front_shiny_female: Any,
    val other: Other,
    val versions: Versions
)

fun Sprites.toPokemonSprites(): PokemonSprites {
    return PokemonSprites(
        frontDefault = frontDefault,
        frontShiny = frontShiny,
    )
}