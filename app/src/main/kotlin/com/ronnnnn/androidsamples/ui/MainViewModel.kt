package com.ronnnnn.androidsamples.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.ronnnnn.androidsamples.domain.random.RandomUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/07.
 */
class MainViewModel @Inject constructor(private val randomUseCase: RandomUseCase) : ViewModel() {

    val title: ObservableField<String> = ObservableField("")
    val imageUrl: ObservableField<String> = ObservableField("")

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        randomUseCase.observe()
                .subscribeOn(Schedulers.io())
                .subscribe({ randomData ->
                    title.set(randomData.data.title)
                    imageUrl.set(randomData.data.images.downsizedMedium.url)
                }).let { compositeDisposable.add(it) }

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