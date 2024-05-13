package com.laoves.mylittleapp.presentation.coin_inventory

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel, //TODO: Perhaps implement hilt viewmodel
) {
    val state = viewModel.state.value


}