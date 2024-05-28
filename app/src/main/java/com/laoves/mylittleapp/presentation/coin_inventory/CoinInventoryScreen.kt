package com.laoves.mylittleapp.presentation.coin_inventory

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.laoves.mylittleapp.presentation.Screen

@Composable
fun CoinInventoryScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    println("STATE: ${state.coins.size}")
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.error.isNotBlank()) {
            Text("Error: ${state.error}")
        } else if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.coins.isNotEmpty()) {
            Text(
                text = "Hey look a coin: ${state.coins[0].name}",
                modifier = Modifier.clickable { navController.navigate(Screen.CoinDetailScreen.route + "/${state.coins[0]}") },
            )
        } else {
            Text(
                text = "Hey look nothing",
            )
        }
    }
}