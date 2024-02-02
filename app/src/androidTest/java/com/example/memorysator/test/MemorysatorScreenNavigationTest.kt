package com.example.memorysator.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.memorysator.ui.MemorysatorApp
import com.example.memorysator.ui.MemorysatorAppScreens
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MemorysatorScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

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
    assertEquals(MemorysatorAppScreens.MAIN_MENU.name, navController.currentBackStackEntry?.destination?.route)
}

}