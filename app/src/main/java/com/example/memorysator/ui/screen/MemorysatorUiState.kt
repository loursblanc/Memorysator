package com.example.memorysator.ui.screen

import com.example.memorysator.data.Difficulty
import com.example.memorysator.data.FakeDatasource
import com.example.memorysator.network.Photo

data class MemorysatorUiState(
    val gameDifficulty: Difficulty = Difficulty.EASY,
    val Photos :List<Photo> = FakeDatasource.mockupIdPhotosList
)
