package ru.kirzak899.location.repository

import ru.kirzak899.location.data.Point

interface PassCoordinatesRepository {

    fun getTokenAuthorization(
        onComplete: (String) -> Unit,
        onError: (String) -> Unit
    )

    fun setLocations(
        authorization: String,
        point: Point,
        onComplete: (String) -> Unit,
        onError: (String) -> Unit
    )
}
