package com.example.memorysator.data

import com.example.memorysator.network.NasaApiService
import com.example.memorysator.network.Photo

 interface ApodPhotosRepository {
     suspend fun getApodPhotos(): List<Photo>
 }

class NetWorkApodPhotosRepository(
    private val nasaApiService: NasaApiService
): ApodPhotosRepository{
    override suspend fun getApodPhotos(): List<Photo> = nasaApiService.getApodPhotos()
}

