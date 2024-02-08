package com.example.memorysator.data

import com.example.memorysator.network.NasaApiService
import com.example.memorysator.data.model.Photo

private const val MAX_PHOTOS = 24
private const val IMAGE_TYPE = "image"

 interface ApodPhotosRepository {
     suspend fun getApodPhotos(): List<Photo>
 }

class NetWorkApodPhotosRepository(
    private val nasaApiService: NasaApiService
): ApodPhotosRepository{
    override suspend fun getApodPhotos(): List<Photo> {
        return filterPhotos(nasaApiService.getApodPhotos())

    }

    private fun filterPhotos(photos: List<Photo>): List<Photo>{
        return photos.filter { photo ->
            photo.mediaType == IMAGE_TYPE && (photo.copyright.isNullOrEmpty() || photo.copyright == "none")
        }
    }

}

