package com.laoves.mylittleapp.presentation.coin_inventory

import com.laoves.mylittleapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
