package com.example.memorysator.fake

import com.example.memorysator.data.ApodPhotosRepository
import com.example.memorysator.network.Photo

class FakeNetworkApodPhotosRepository : ApodPhotosRepository {
    override suspend fun getApodPhotos(): List<Photo> {
        return FakeDataSource.mockupPhotosList
    }
}