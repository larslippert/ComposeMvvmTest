package com.laoves.mylittleapp.data.remote.pokemon.dto

import com.google.gson.annotations.SerializedName
import com.laoves.mylittleapp.domain.model.pokemon.PokemonStat

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: StatX
)

fun Stat.toPokemonStat(): PokemonStat {
    return PokemonStat(
        name = stat.name,
        baseStat = baseStat,
    )
}