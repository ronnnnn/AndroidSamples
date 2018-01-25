package com.ronnnnn.data.giphy.common.entity

import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class User(
        @Json(name = "avatar_url")
        val avatarUrl: String,
        @Json(name = "banner_url")
        val bannerUrl: String,
        @Json(name = "profile_url")
        val profileUrl: String,
        val username: String,
        @Json(name = "display_name")
        val displayName: String,
        @Json(name = "twitter")
        val twitter: String?
)