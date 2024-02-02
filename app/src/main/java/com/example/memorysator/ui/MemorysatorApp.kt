package com.example.memorysator.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.memorysator.R


enum class MemorysatorAppScreens(@StringRes val title: Int){
    MAIN_MENU(title = R.string.game_title),
    RULES(title = R.string.game_title),
    GAME(title = R.string.game_title),
    DETAILS(title = R.string.game_title),
}

@Composable
fun MemorysatorApp() {

}