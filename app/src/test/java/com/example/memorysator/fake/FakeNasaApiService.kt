package com.example.memorysator.fake

import com.example.memorysator.network.NasaApiService
import com.example.memorysator.network.Photo

class FakeNasaApiService : NasaApiService{
    override suspend fun getApodPhotos(): List<Photo> {
        return FakeDataSource.mockupPhotosList
    }
}