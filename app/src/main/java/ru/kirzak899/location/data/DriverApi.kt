package ru.kirzak899.location.data

import io.reactivex.Single
import retrofit2.http.*

interface DriverApi {

    @POST("/v3/driver/auth/auth")
    fun getToken(
        @Body bodyGetAuth: BodyGetAuth
    ): Single<ServerItemsWrapper>

    @FormUrlEncoded
    @POST("/v3/locations/create")
    fun setLocation(
        @Header("Authorization") auth: String,
        @Field("point") point: Point,
        @Field("sent") date: String,
        @Field("sent_time") sentTime: String?,
        @Field("trip_id") tripId: Int?,
        @Field("type") type: Int?,
        @Field("speed") speed: Float,
    ): Single<ResultRequestLocations>
}
