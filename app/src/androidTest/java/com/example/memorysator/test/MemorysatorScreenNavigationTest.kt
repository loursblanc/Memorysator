package com.example.memorysator.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.memorysator.ui.MemorysatorApp
import org.junit.Before
import org.junit.Rule

@get:Rule
val composeTestRule = createAndroidComposeRule<ComponentActivity>()
private lateinit var navController: TestNavHostController

@Before
fun setupMemorysatorNavHost(){
    composeTestRule.setContent {
        navController = TestNavHostController(LocalContext.current).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
        }
        MemorysatorApp() }
}

class MemorysatorScreenNavigationTest {
}