package com.laoves.mylittleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laoves.mylittleapp.presentation.Screen
import com.laoves.mylittleapp.presentation.coin_details.CoinDetailScreen
import com.laoves.mylittleapp.presentation.coin_inventory.CoinInventoryScreen
import com.laoves.mylittleapp.presentation.ui.theme.MyLittleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLittleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinInventoryScreen.route,
                    ) {
                        composable(
                            route = Screen.CoinInventoryScreen.route
                        ) {
                            CoinInventoryScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

