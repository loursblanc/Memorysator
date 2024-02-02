package com.example.memorysator.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.memorysator.R
import com.example.memorysator.ui.screen.DetailsScreen
import com.example.memorysator.ui.screen.GameScreen
import com.example.memorysator.ui.screen.MainMenuScreen


enum class MemorysatorAppScreens(@StringRes val title: Int){
    MAIN_MENU(title = R.string.game_title),
    RULES(title = R.string.game_title),
    GAME(title = R.string.game_title),
    DETAILS(title = R.string.game_title),
}

@Composable
fun MemorysatorApp(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController()) {

    NavHost(navController = navController, startDestination = MemorysatorAppScreens.MAIN_MENU.name){
        composable(route= MemorysatorAppScreens.MAIN_MENU.name){
            MainMenuScreen()
        }

        composable(route = MemorysatorAppScreens.DETAILS.name){
            DetailsScreen()
        }

        composable(route = MemorysatorAppScreens.GAME.name){
            GameScreen()
        }

        composable(route = MemorysatorAppScreens.DETAILS.name){
            DetailsScreen()
        }
    }

}