package com.laoves.mylittleapp.data.repository

import com.laoves.mylittleapp.data.remote.coin.CoinApi
import com.laoves.mylittleapp.data.remote.coin.dto.CoinDetailDto
import com.laoves.mylittleapp.data.remote.coin.dto.CoinDto
import com.laoves.mylittleapp.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}