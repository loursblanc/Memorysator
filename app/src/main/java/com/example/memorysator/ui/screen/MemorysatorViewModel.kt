package com.example.memorysator.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memorysator.data.Difficulty
import com.example.memorysator.network.NasaApi
import com.example.memorysator.network.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MemorysatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MemorysatorUiState())
    val uiState: StateFlow<MemorysatorUiState> = _uiState.asStateFlow()


    fun setDifficulty( difficulty: Difficulty){
        _uiState.update { currentState ->
            currentState.copy(gameDifficulty = difficulty)
        }
    }

    fun setCurrentPhoto(currentPhoto: Photo){
        _uiState.update { currentState ->
            currentState.copy(currentPhoto = currentPhoto)
        }
    }

    fun getApodPhotos() : Int{
        val response = NasaApi.retrofitService.getApodPhotos().execute()

        if (response.isSuccessful) {
            val photos = response.body()
            return photos?.size ?: 0
        }else{
            return 0
        }
    }
}