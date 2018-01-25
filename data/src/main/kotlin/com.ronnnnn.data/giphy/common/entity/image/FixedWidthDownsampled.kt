package com.ronnnnn.data.giphy.common.entity.image

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class FixedWidthDownsampled(
        val url: String,
        val width: String,
        val height: String,
        val size: String,
        val webp: String,
        @Json(name = "webp_size")
        val webpSize: String
)