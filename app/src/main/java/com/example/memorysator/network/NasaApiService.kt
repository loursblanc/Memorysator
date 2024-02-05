package com.example.memorysator.network

import retrofit2.http.GET

interface NasaApiService {
    @GET("apod?api_key=DEMO_KEY&count=2")
    suspend fun getApodPhotos(): List<Photo>
}