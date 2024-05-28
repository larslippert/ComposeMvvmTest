package com.laoves.mylittleapp.domain.use_case.get_coins

import com.laoves.mylittleapp.common.Resource
import com.laoves.mylittleapp.data.remote.dto.toCoin
import com.laoves.mylittleapp.domain.model.Coin
import com.laoves.mylittleapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown http error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown IO error"))
        }
    }
}