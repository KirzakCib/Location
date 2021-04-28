package ru.kirzak899.location.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyGetAuth(
    val login: String = "917428730930",
    val password: String = "198711",
    val device_info: DeviceInfo = DeviceInfo()
)
