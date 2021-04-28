package ru.kirzak899.location.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Token(
    val token: String,
    val refresh_token: String
)
