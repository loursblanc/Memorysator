package com.example.memorysator

import android.app.Application
import com.example.memorysator.data.AppContainer
import com.example.memorysator.data.DefaultAppContainer

class MemorysatorApplication: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}