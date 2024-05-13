package com.laoves.mylittleapp.presentation.coin_details

import com.laoves.mylittleapp.domain.model.Coin
import com.laoves.mylittleapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
