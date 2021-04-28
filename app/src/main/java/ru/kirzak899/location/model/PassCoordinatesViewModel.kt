package ru.kirzak899.location.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.kirzak899.location.data.Point
import ru.kirzak899.location.repository.PassCoordinatesRepository
import javax.inject.Inject

@HiltViewModel
class PassCoordinatesViewModel @Inject constructor(
    private val repository: PassCoordinatesRepository
) : ViewModel() {

    private val isLoadingLiveData = MutableLiveData<Boolean>()
    private val tokenLiveData = MutableLiveData<String>()
    private val toastLiveData = MutableLiveData<String>()

    val toast: LiveData<String>
        get() = toastLiveData

    val isLoading: LiveData<Boolean>
        get() = isLoadingLiveData

    val token: LiveData<String>
        get() = tokenLiveData

    fun getTokenAuth() {
        repository.getTokenAuthorization(
            onComplete = { tokenLiveData.postValue("Bearer $it") },
            onError = { toastLiveData.postValue(it) }
        )
    }

    fun setLocation() {
        isLoadingLiveData.postValue(true)
        repository.setLocations(
            token.value.toString(),
            Point(lat, lng),
            onComplete = {
                toastLiveData.postValue(it)
                isLoadingLiveData.postValue(false)
            },
            onError = {
                toastLiveData.postValue(it)
                isLoadingLiveData.postValue(false)
            }
        )
    }

    companion object {
        private const val lat = 82.0555F
        private const val lng = 55.0121F
    }
}
