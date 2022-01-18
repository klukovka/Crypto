package com.example.crypto.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crypto.R
import com.example.crypto.presentation.coin_detail.CoinDetailScreen
import com.example.crypto.presentation.coin_list.CoinListScreen
import com.example.crypto.presentation.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                Surface (color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route,
                    ){
                        composable(
                            route = Screen.CoinListScreen.route,
                        ){
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}",
                        ){
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}