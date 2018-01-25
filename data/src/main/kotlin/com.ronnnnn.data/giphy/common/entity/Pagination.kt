package com.ronnnnn.data.giphy.common.entity

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class Pagination(
        val offset: Int,
        @Json(name = "total_count")
        val totalCount: Int,
        val count: Int
)