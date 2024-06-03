package com.laoves.mylittleapp.data.remote.pokemon.dto

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)