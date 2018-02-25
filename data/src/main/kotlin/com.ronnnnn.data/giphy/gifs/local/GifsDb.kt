package com.ronnnnn.data.giphy.gifs.local

import com.ronnnnn.data.giphy.gifs.entity.RandomData
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by kokushiseiya on 2018/02/26.
 */
interface GifsDb {

    fun observeRandom(): Flowable<RandomData>

    fun updateRandom(randomData: RandomData): Completable
}