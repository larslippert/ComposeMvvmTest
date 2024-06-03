package com.laoves.mylittleapp.data.remote.coin

import com.laoves.mylittleapp.data.remote.coin.dto.CoinDetailDto
import com.laoves.mylittleapp.data.remote.coin.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}