package ru.kirzak899.location.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Point(
    val lat: Float,
    val lng: Float
)
