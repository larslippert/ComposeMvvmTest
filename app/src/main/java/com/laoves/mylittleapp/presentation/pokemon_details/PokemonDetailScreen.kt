package com.laoves.mylittleapp.presentation.pokemon_details

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlin.random.Random

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    println("State: $state")

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.pokemon != null) {
            val pokemonName =
                state.pokemon.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            val isShiny = Random.nextInt(1, 4) == 1
            Box(modifier = Modifier.clickable {
                val randomNumber = Random.nextInt(1,152).toString()
                Log.d("SCREEN", "Number $randomNumber")
                viewModel.getPokemonById(randomNumber)
            }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("${if (isShiny) "Shiny $pokemonName" else pokemonName} I choose you!")
                    AsyncImage(
                        modifier = Modifier.size(146.dp),
                        model = if (isShiny) state.pokemon.sprites.frontShiny else state.pokemon.sprites.frontDefault,
                        contentDescription = null
                    )
                }
            }
            //TODO: Insert image
        } else if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error.isNotBlank()) {
            Text("Kunne ikke hente Pokemon.")
        } else {
            Text("Der skete en ukendt fejl.")
        }
    }
}