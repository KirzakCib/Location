package ru.kirzak899.location.repository

import android.annotation.SuppressLint
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.kirzak899.location.data.DriverApi
import ru.kirzak899.location.data.Point
import ru.kirzak899.location.data.ServerItemsWrapper
import javax.inject.Inject

class PassCoordinatesRepositoryImpl @Inject constructor(
    private val tokenApi: Single<ServerItemsWrapper>,
    private val driverApi: DriverApi
) : PassCoordinatesRepository {

    @SuppressLint("CheckResult")
    override fun getTokenAuthorization(
        onComplete: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        tokenApi
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onComplete(it.result.token) },
                { onError("Ошибка авторизации, проверьте подключение к сети") }
            )
    }

    @SuppressLint("CheckResult")
    override fun setLocations(
        authorization: String,
        point: Point,
        onComplete: (String) -> Unit,
        onError: (String) -> Unit
    ) {
        driverApi.setLocation(
            authorization,
            point,
            "2020-10-21 18:37:10",
            "2020-10-21T18:37:10+07:00",
            2146440,
            1,
            60F
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.result) onComplete("Успешно добавлено")
                    else onError("Не удалось сохранить кординаты")
                },
                { onError(it.message.toString()) }
            )
    }
}

