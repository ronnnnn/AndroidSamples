package com.ronnnnn.data.giphy.gifs.entity

import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.common.entity.Meta
import com.ronnnnn.data.giphy.common.entity.Pagination

/**
 * Created by kokushiseiya on 2018/01/27.
 */
data class TrendingData(
        val data: List<Gif>,
        val pagination: Pagination,
        val meta: Meta
)