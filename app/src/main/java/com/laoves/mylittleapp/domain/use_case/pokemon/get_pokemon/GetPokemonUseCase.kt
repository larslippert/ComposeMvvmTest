package com.laoves.mylittleapp.domain.use_case.pokemon.get_pokemon

import android.net.http.HttpException
import com.laoves.mylittleapp.common.Resource
import com.laoves.mylittleapp.data.remote.pokemon.dto.toPokemonDetail
import com.laoves.mylittleapp.domain.model.pokemon.PokemonDetail
import com.laoves.mylittleapp.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokemonRepository) {
    operator fun invoke(pokemonId: String): Flow<Resource<PokemonDetail>> = flow {
        try {
            emit(Resource.Loading())
            val pokemon = repository.getPokemonById(pokemonId).toPokemonDetail()
            emit(Resource.Success(pokemon))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown http error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown IO error"))
        }
    }
}