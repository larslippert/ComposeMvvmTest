package com.laoves.mylittleapp.domain.model.coin

import com.laoves.mylittleapp.data.remote.coin.dto.Team

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
