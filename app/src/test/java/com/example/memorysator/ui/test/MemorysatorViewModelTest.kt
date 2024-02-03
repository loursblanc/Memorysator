package com.example.memorysator.ui.test


import com.example.memorysator.data.Difficulty
import com.example.memorysator.ui.screen.MemorysatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class MemorysatorViewModelTest {
    private val viewModel = MemorysatorViewModel()

    @Test
    fun memorysatorViewModel_Initilization_DefaultMemorysatorUiState(){
        val memorysatorUiState = viewModel.uiState.value
        assertEquals(Difficulty.EASY,memorysatorUiState.gameDifficulty)
    }

    @Test
    fun memorysatorViewModel_ChangedDifficulty_UiStateGameDifficultyChange(){
        viewModel.setDifficulty(Difficulty.HARD)
        val memorysatorUiState = viewModel.uiState.value
        assertEquals(Difficulty.HARD,memorysatorUiState.gameDifficulty)
    }

}