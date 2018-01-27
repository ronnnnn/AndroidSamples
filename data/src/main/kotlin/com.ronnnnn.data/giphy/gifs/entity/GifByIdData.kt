package com.ronnnnn.data.giphy.gifs.entity

import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.common.entity.Meta

/**
 * Created by kokushiseiya on 2018/01/27.
 */
data class GifByIdData(
        val data: Gif,
        val meta: Meta
)