package ru.kirzak899.location.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerItemsWrapper(
    val result: Token
)
