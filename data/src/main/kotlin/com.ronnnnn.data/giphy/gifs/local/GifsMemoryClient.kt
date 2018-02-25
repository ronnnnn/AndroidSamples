package com.ronnnnn.data.giphy.gifs.local

import com.ronnnnn.data.giphy.gifs.entity.RandomData
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/26.
 */
class GifsMemoryClient @Inject constructor() : GifsDb {

    private val randomSubject: BehaviorSubject<RandomData> = BehaviorSubject.create()

    override fun observeRandom(): Flowable<RandomData> =
            randomSubject.toFlowable(BackpressureStrategy.LATEST)

    override fun updateRandom(randomData: RandomData): Completable =
            Completable.fromAction {
                randomSubject.onNext(randomData)
            }
}