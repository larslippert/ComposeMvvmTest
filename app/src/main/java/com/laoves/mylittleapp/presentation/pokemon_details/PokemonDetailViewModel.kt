package com.laoves.mylittleapp.presentation.pokemon_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laoves.mylittleapp.common.Constants.PARAM_POKEMON_ID
import com.laoves.mylittleapp.common.Resource
import com.laoves.mylittleapp.domain.use_case.pokemon.get_pokemon.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    savedStateHandle: SavedStateHandle //Contains the navigation param (pokemonId)
) : ViewModel() {

    private val _state = mutableStateOf(PokemonDetailState())
    val state: State<PokemonDetailState> = _state

    init {
        Log.d("VIEWMODEL", "Initializing!")
//        savedStateHandle.get<String>(PARAM_POKEMON_ID)?.let { pokemonId ->
//            Log.d("VIEWMODEL", pokemonId)
//            getPokemonById(pokemonId)
//        }?.run {
//            Log.d("VIEWMODEL", "No pokemonId")
//        }
        val randomNumber = Random.nextInt(1,152).toString()
        Log.d("VIEWMODEL", "Number $randomNumber")

        getPokemonById(randomNumber)
    }

    fun getPokemonById(pokemonId: String) {
        getPokemonUseCase(pokemonId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonDetailState(pokemon = result.data)
                }
                is Resource.Error -> {
                    _state.value = PokemonDetailState(error = result.message ?: "Unknown error")
                }
                is Resource.Loading -> {
                    _state.value = PokemonDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}