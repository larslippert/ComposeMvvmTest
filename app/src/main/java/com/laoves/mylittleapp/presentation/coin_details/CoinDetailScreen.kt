package com.laoves.mylittleapp.presentation.coin_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (state.coin != null) {
            Text(text = "${state.coin.name} is the very first coin!")
        } else if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error.isNotBlank()) {
            Text("Error: ${state.error}")
        } else {
            Text("Digital style!")
        }
    }
}