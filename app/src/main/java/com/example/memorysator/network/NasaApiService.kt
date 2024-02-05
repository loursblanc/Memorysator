package com.example.memorysator.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://api.nasa.gov/planetary/"
val json = Json {
    ignoreUnknownKeys = true

}
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface NasaAPiService {
    @GET("apod?api_key=DEMO_KEY&count=2")
    fun getApodPhotos(): Call<List<Photo>>
}

object NasaApi{

    val retrofitService: NasaAPiService by lazy {
        retrofit.create(NasaAPiService::class.java)
    }
}