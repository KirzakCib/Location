package ru.kirzak899.location.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeviceInfo(
    val os: String = "android",
    val app_version: String = "71",
    val hardware_id: String = "b1g25d21-54d5-k1f1-8d83-5443b51b1328"
)
