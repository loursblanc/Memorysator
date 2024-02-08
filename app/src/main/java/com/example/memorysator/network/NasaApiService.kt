package com.example.memorysator.network

import com.example.memorysator.data.model.Photo
import retrofit2.http.GET

private const val appKey = "ycHQSWh4sgtiEuAc3S2Fz3wPWKOXOCydz4m5bmGi"

interface NasaApiService {
    @GET("apod?api_key=$appKey&count=30")
    suspend fun getApodPhotos(): List<Photo>
}