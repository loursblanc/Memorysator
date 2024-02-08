package com.example.memorysator.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.memorysator.MemorysatorApplication
import com.example.memorysator.data.ApodPhotosRepository
import com.example.memorysator.data.Difficulty
import com.example.memorysator.data.model.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MemorysatorViewModel (private val apodPhotosRepository: ApodPhotosRepository): ViewModel() {
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

    fun getApodPhotos(){
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(apiState = ConnectionState.LOADING)
            }
            try {
                val apodPhotos = apodPhotosRepository.getApodPhotos()
                _uiState.update { currentState ->
                    currentState.copy(photos = apodPhotos, apiState = ConnectionState.SUCESS)
                }
            } catch (e: IOException) {
                _uiState.update { currentState ->
                    currentState.copy(apiState = ConnectionState.ERROR)
                }
            } catch (e: HttpException) {
                _uiState.update { currentState ->
                    currentState.copy(apiState = ConnectionState.ERROR)
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MemorysatorApplication)
                val apodPhotosRepository = application.container.apodPhotosRepository
                MemorysatorViewModel(apodPhotosRepository = apodPhotosRepository)
            }
        }
    }
}