package com.example.memorysator.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo (
    val title: String,
    //val url: Int, //Todo Must be transformed into a String once the connection to the API is made
    val explanation: String,
    @SerialName(value = "media_type")
    val mediaType: String,
    @SerialName("copyright")
    val copyright: String? = null,
){
    val formattedCopyright: String = copyright ?: "none"
}