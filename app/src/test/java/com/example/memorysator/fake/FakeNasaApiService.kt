package com.example.memorysator.fake

import com.example.memorysator.network.NasaApiService
import com.example.memorysator.data.model.Photo

class FakeNasaApiService : NasaApiService{
    override suspend fun getApodPhotos(): List<Photo> {
        return FakeDataSource.mockupPhotosList
    }
}