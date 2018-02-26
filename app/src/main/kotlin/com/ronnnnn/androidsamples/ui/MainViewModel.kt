package com.ronnnnn.androidsamples.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ronnnnn.androidsamples.domain.random.RandomUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/07.
 */
class MainViewModel @Inject constructor(private val randomUseCase: RandomUseCase) : ViewModel() {

    val title: MutableLiveData<String> = MutableLiveData()
    val imageUrl: MutableLiveData<String> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        randomUseCase.observe()
                .subscribeOn(Schedulers.io())
                .subscribe({ randomData ->
                    title.postValue(randomData.data.title)
                    imageUrl.postValue(randomData.data.images.downsizedMedium.url)
                })
                .let { compositeDisposable.add(it) }
        fetchRandomData()
    }

    fun updateRandom() {
        fetchRandomData()
    }

    private fun fetchRandomData() {
        randomUseCase.fetch("harry potter")
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Timber.d("fetch succeed")
                })
                .let { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}