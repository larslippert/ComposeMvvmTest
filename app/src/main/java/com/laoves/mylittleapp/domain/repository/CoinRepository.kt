package com.laoves.mylittleapp.domain.repository

import com.laoves.mylittleapp.data.remote.dto.CoinDetailDto
import com.laoves.mylittleapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoin(coinId: String): CoinDetailDto
}