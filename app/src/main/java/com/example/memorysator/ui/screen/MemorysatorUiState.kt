package com.example.memorysator.ui.screen

import com.example.memorysator.data.Difficulty
import com.example.memorysator.data.FakeDatasource
import com.example.memorysator.network.Photo

data class MemorysatorUiState(
    val currentPhoto: Photo = Photo("",0,"","","",),
    val gameDifficulty: Difficulty = Difficulty.EASY,
    val photos :List<Photo> = FakeDatasource.mockupIdPhotosList,
)