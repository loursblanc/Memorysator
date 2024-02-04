package com.example.memorysator.network

data class Photo (
    val title: String,
    val url: Int, //Todo Must be transformed into a String once the connection to the API is made
    val explanation: String,
    val mediaType: String,
    val copyright: String?,
){
    val formattedCopyright: String = copyright ?: "none"
}