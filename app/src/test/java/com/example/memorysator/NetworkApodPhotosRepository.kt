package com.example.memorysator

import com.example.memorysator.data.NetWorkApodPhotosRepository
import com.example.memorysator.fake.FakeDataSource
import com.example.memorysator.fake.FakeNasaApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkApodPhotosRepository {

    @Test
    fun networkApodPhotosRepository_getApodPhotos_verifyPhotoList()= runTest {
        val repository = NetWorkApodPhotosRepository(nasaApiService = FakeNasaApiService())
        assertEquals(FakeDataSource.mockupFilteredPhotosList,repository.getApodPhotos())
    }
}
