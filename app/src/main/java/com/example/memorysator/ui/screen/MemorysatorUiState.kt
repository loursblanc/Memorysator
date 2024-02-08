package com.example.memorysator.ui.screen

import com.example.memorysator.data.Difficulty
import com.example.memorysator.data.FakeDatasource
import com.example.memorysator.network.Photo

 enum class ConnectionState(){
     LOADING,
     SUCESS,
     ERROR
 }

data class MemorysatorUiState(
    val currentPhoto: Photo = Photo("","","",""),
    val gameDifficulty: Difficulty = Difficulty.EASY,
    val photos :List<Photo> = emptyList(),
    val apiState: ConnectionState = ConnectionState.LOADING
)
