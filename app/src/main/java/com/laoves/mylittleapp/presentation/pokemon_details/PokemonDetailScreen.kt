package com.laoves.mylittleapp.presentation.pokemon_details

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.laoves.mylittleapp.common.helpers.getColorFromType
import com.laoves.mylittleapp.presentation.components.SpriteFrame
import com.laoves.mylittleapp.presentation.ui.theme.allTypeColors
import com.laoves.mylittleapp.presentation.ui.theme.bugColor
import com.laoves.mylittleapp.presentation.ui.theme.colorPrimary
import com.laoves.mylittleapp.presentation.ui.theme.darkGray
import com.laoves.mylittleapp.presentation.ui.theme.goldColorBrush
import com.laoves.mylittleapp.presentation.ui.theme.rainbowColorBrush
import com.laoves.mylittleapp.presentation.ui.theme.standardParty
import com.laoves.mylittleapp.presentation.ui.theme.waterColor
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGray),
        contentAlignment = Alignment.Center
    ) {
        if (state.pokemon != null) {
            val pokemonName =
                state.pokemon.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
            val isShiny = Random.nextInt(1, 4) == 1
            val isGay = Random.nextInt(1, 10) == 1
            val primaryTypeColor = getColorFromType(state.pokemon.types.first().type.name)
            val secondaryTypeColor =
                if (state.pokemon.types.size > 1) getColorFromType(state.pokemon.types[1].type.name) else primaryTypeColor

            Box(modifier = Modifier.clickable {
                val randomNumber = Random.nextInt(1, 152).toString()
                Log.d("SCREEN", "Number $randomNumber")
                viewModel.getPokemonById(randomNumber)
            }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "${if (isShiny) "Shiny " else ""}${if (isGay) if (isShiny) "gay " else "Gay " else ""}$pokemonName I choose you!",
                        color = colorPrimary,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    SpriteFrame(
                        model = if (isShiny) state.pokemon.sprites.frontShiny else state.pokemon.sprites.frontDefault,
                        frameBrush = if (isGay) rainbowColorBrush else goldColorBrush,
                        backgroundColors = listOf(primaryTypeColor, secondaryTypeColor)
                    )
                }
            }

            if (isShiny) {
                KonfettiView(modifier = Modifier.fillMaxSize(), parties = listOf(standardParty))
            }
        } else if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error.isNotBlank()) {
            Text("Kunne ikke hente Pokemon.")
        } else {
            Text("Der skete en ukendt fejl.")
        }
    }
}
