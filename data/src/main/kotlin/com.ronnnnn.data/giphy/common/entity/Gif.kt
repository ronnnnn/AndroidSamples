package com.ronnnnn.data.giphy.common.entity

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/25.
 */
data class Gif(
        val type: String,
        val id: String,
        val slug: String,
        val url: String,
        @Json(name = "bitly_url")
        val bitlyUrl: String,
        @Json(name = "embed_url")
        val embedUrl: String,
        val username: String?,
        val source: String,
        val rating: String,
        val user: User?,
        @Json(name = "source_tld")
        val sourceTld: String,
        @Json(name = "source_post_url")
        val sourcePostUrl: String,
        @Json(name = "update_datetime")
        val updateDatetime: String?,
        @Json(name = "create_datetime")
        val createDatetime: String?,
        @Json(name = "import_datetime")
        val importDatetime: String,
        @Json(name = "trending_datetime")
        val trendingDatetime: String?,
        val images: Images,
        val title: String
)