package com.laoves.mylittleapp.presentation

sealed class Screen(val route: String) {
    object CoinInventoryScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
    object PokemonDetailScreen: Screen("pokemon_detail_screen")
}
