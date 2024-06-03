package com.laoves.mylittleapp.domain.repository

import com.laoves.mylittleapp.data.remote.coin.dto.CoinDetailDto
import com.laoves.mylittleapp.data.remote.coin.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoin(coinId: String): CoinDetailDto
}