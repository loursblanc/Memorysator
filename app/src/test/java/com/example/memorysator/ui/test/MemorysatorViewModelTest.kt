package com.example.memorysator.ui.test


import com.example.memorysator.data.Difficulty
import com.example.memorysator.network.Photo
import com.example.memorysator.ui.screen.MemorysatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Test


class MemorysatorViewModelTest {
    private val viewModel = MemorysatorViewModel()

    @Test
    fun memorysatorViewModel_Initilization_DefaultMemorysatorUiState(){
        val memorysatorUiState = viewModel.uiState.value
        val defaultDifficulty = Difficulty.EASY
        val defaultCurrentPhoto = Photo("",0,"","","")
        assertEquals(defaultDifficulty,memorysatorUiState.gameDifficulty)
        assertEquals(defaultCurrentPhoto,memorysatorUiState.currentPhoto)
        //assertEquals(defaultCurrentPhoto,memorysatorUiState.photos)
    }

    @Test
    fun memorysatorViewModel_ChangedDifficulty_UiStateGameDifficultyChange(){
        viewModel.setDifficulty(Difficulty.HARD)
        val memorysatorUiState = viewModel.uiState.value
        assertEquals(Difficulty.HARD,memorysatorUiState.gameDifficulty)
    }

    @Test
    fun memorysatorVIewModel_ChangedCurrentPhoto_UiStateCurrentDifficultyChange(){
        val photoTest = Photo ("Test",0,"test","image","none")
        viewModel.setCurrentPhoto(photoTest)
        val memorysatorUiState = viewModel.uiState.value
        assertEquals(photoTest,memorysatorUiState.currentPhoto)
    }

}