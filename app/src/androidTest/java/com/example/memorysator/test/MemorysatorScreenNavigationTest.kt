package com.example.memorysator.test

import com.example.memorysator.R
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.memorysator.ui.MemorysatorApp
import com.example.memorysator.ui.MemorysatorAppScreens
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MemorysatorScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController
    private val  firstElement = 0

    @Before
    fun setupMemorysatorNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MemorysatorApp(navController = navController) }
    }

    @Test
    fun memorysatorNavHost_verifyStartDestination(){
        navController.assertCurrentRouteName(MemorysatorAppScreens.MAIN_MENU.name)
    }

    @Test
    fun memorysatorNavHost_clickRulesOnMainMenuScreen_navigatesToRulesScreen(){
        navigateToRulesScreen()
        navController.assertCurrentRouteName(MemorysatorAppScreens.RULES.name)
    }

    @Test
    fun memorysatorNavHost_clickPlayOnMainMenuScreen_navigatesToGameScreen() {
        navigateToGameScreen()
        navController.assertCurrentRouteName(MemorysatorAppScreens.GAME.name)
    }
    @Test
    fun memorysatorNavHost_clickDetailsIconOnGameScreen_navigatesToDetailsScreen() {
        navigateToDetailsScreen()
        navController.assertCurrentRouteName(MemorysatorAppScreens.DETAILS.name)
    }


    @Test
    fun memorysatorNavHost_clickBackToMenuOnRulesScreen_navigatesToMainMenuScreen() {
        navigateToRulesScreen()
        composeTestRule.onNodeWithStringId(R.string.return_main_menu_button).performClick()
        navController.assertCurrentRouteName(MemorysatorAppScreens.MAIN_MENU.name)
    }
    @Test
    fun memorysatorNavHost_clickBackToMenuOnGameScreen_navigatesToMainMenuScreen() {
        navigateToGameScreen()
        composeTestRule.onNodeWithStringId(R.string.return_main_menu_button).performClick()
        navController.assertCurrentRouteName(MemorysatorAppScreens.MAIN_MENU.name)
    }

    @Test
    fun memorysatorNavHost_clickBackToMenuOnGameScreen_navigatesGameScreen() {
        navigateToDetailsScreen()
        composeTestRule.onNodeWithStringId(R.string.return_game_button).performClick()
        navController.assertCurrentRouteName(MemorysatorAppScreens.GAME.name)
    }




    private fun navigateToRulesScreen(){
        composeTestRule.onNodeWithStringId(R.string.rules_button).performClick()
    }

    private fun  navigateToGameScreen(){
        composeTestRule.onNodeWithStringId(R.string.play_button).performClick()
    }

    private fun navigateToDetailsScreen(){
        navigateToGameScreen()
        composeTestRule.onAllNodesWithTagId(R.string.details_button)[firstElement].performClick()
    }

}