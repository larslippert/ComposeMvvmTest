package com.laoves.mylittleapp.di

import com.laoves.mylittleapp.common.Constants.COIN_BASE_URL
import com.laoves.mylittleapp.common.Constants.POKEMON_BASE_URL
import com.laoves.mylittleapp.data.remote.coin.CoinApi
import com.laoves.mylittleapp.data.remote.pokemon.PokemonApi
import com.laoves.mylittleapp.data.repository.CoinRepositoryImpl
import com.laoves.mylittleapp.data.repository.PokemonRepositoryImpl
import com.laoves.mylittleapp.domain.repository.CoinRepository
import com.laoves.mylittleapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Makes sure AppModule lives as long as the App
object AppModule {

    @Provides
    @Singleton // Only one instance of this method
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(COIN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(POKEMON_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }
}