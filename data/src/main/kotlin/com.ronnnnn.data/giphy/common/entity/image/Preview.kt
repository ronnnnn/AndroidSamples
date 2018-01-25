package com.ronnnnn.data.giphy.common.entity.image

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class Preview(
        val width: String,
        val height: String,
        val mp4: String,
        @Json(name = "mp4_size")
        val mp4Size: String
)