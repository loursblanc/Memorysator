package com.example.memorysator.data


import com.example.memorysator.network.NasaApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val apodPhotosRepository: ApodPhotosRepository
}

class DefaultAppContainer : AppContainer{

    private val baseUrl = "https://api.nasa.gov/planetary/"

    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: NasaApiService by lazy {
        retrofit.create(NasaApiService::class.java)
    }

    override val apodPhotosRepository: ApodPhotosRepository by lazy {
        NetWorkApodPhotosRepository(retrofitService)
    }

}