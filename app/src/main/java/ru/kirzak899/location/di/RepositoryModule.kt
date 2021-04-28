package ru.kirzak899.location.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.kirzak899.location.repository.PassCoordinatesRepository
import ru.kirzak899.location.repository.PassCoordinatesRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun providesPassCoordinatesRepository(
        passCoordinatesRepositoryImpl: PassCoordinatesRepositoryImpl
    ): PassCoordinatesRepository
}
