package com.ronnnnn.data.giphy.gifs.local

import com.ronnnnn.data.giphy.gifs.entity.RandomData
import com.ronnnnn.data.giphy.gifs.entity.TrendingData
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/26.
 */
class GifsMemoryClient @Inject constructor() : GifsDb {

    private val trendingSubject: BehaviorSubject<TrendingData> = BehaviorSubject.create()
    private val randomSubject: BehaviorSubject<RandomData> = BehaviorSubject.create()

    override fun observeTrending(): Flowable<TrendingData> =
            trendingSubject.toFlowable(BackpressureStrategy.LATEST)

    override fun updateTrending(trendingData: TrendingData): Completable =
            Completable.fromAction {
                trendingSubject.onNext(trendingData)
            }

    override fun observeRandom(): Flowable<RandomData> =
            randomSubject.toFlowable(BackpressureStrategy.LATEST)

    override fun updateRandom(randomData: RandomData): Completable =
            Completable.fromAction {
                randomSubject.onNext(randomData)
            }
}