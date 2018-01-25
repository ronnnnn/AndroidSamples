package com.ronnnnn.data.giphy.common.entity

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class Meta(
        val msg: String,
        val status: Int,
        @Json(name = "response_id")
        val responseId: String
)