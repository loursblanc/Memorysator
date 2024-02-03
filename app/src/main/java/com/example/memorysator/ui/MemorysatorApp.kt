package com.example.memorysator.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.memorysator.R
import com.example.memorysator.ui.screen.DetailsScreen
import com.example.memorysator.ui.screen.GameScreen
import com.example.memorysator.ui.screen.MainMenuScreen
import com.example.memorysator.ui.screen.MemorysatorViewModel
import com.example.memorysator.ui.screen.RulesScreen
import androidx.lifecycle.viewmodel.compose.viewModel


enum class MemorysatorAppScreens(@StringRes val title: Int){
    MAIN_MENU(title = R.string.game_title),
    RULES(title = R.string.game_title),
    GAME(title = R.string.game_title),
    DETAILS(title = R.string.game_title),
}

@Composable
fun MemorysatorApp(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController(),viewModel: MemorysatorViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    NavHost(navController = navController, startDestination = MemorysatorAppScreens.MAIN_MENU.name){
        composable(route= MemorysatorAppScreens.MAIN_MENU.name){
            MainMenuScreen(
                onStartButtonClicked = {navController.navigate(MemorysatorAppScreens.GAME.name)},
                onRulesButtonClicked = {navController.navigate(MemorysatorAppScreens.RULES.name)},
                onSelectionChanged = {viewModel.setDifficulty(it)},
                uiState = uiState
            )
        }

        composable(route = MemorysatorAppScreens.RULES.name){
            RulesScreen(onBackToMenuButtonClicked = { navController.popBackStack()})
        }

        composable(route = MemorysatorAppScreens.GAME.name){
            GameScreen(
                onBackToMenuButtonClicked = { navController.popBackStack()},
                onDetailsButtonClicked = { navController.navigate((MemorysatorAppScreens.DETAILS.name))}
            )
        }

        composable(route = MemorysatorAppScreens.DETAILS.name){
            DetailsScreen(onBackToMenuButtonClicked = { navController.popBackStack()})
        }
    }

}