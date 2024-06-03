package com.laoves.mylittleapp.domain.use_case.coin.get_coin

import com.laoves.mylittleapp.common.Resource
import com.laoves.mylittleapp.data.remote.coin.dto.toCoinDetail
import com.laoves.mylittleapp.domain.model.coin.CoinDetail
import com.laoves.mylittleapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown http error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown IO error"))
        }
    }
}