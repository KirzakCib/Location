package ru.kirzak899.location.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.kirzak899.location.data.BodyGetAuth
import ru.kirzak899.location.data.DriverApi
import ru.kirzak899.location.data.ServerItemsWrapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): Retrofit = Retrofit.Builder()
        .baseUrl("https://driver2stage1.iwayex.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient())
        .build()

    @Provides
    @Singleton
    fun providesRetrofit(retrofit: Retrofit): DriverApi = retrofit.create()

    @Provides
    @Singleton
    fun providesTokenApi(driverApi: DriverApi): Single<ServerItemsWrapper> =
        driverApi.getToken(BodyGetAuth())
}
