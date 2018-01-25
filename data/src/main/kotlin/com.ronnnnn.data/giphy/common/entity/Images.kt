package com.ronnnnn.data.giphy.common.entity

import com.ronnnnn.data.giphy.common.entity.image.*
import com.squareup.moshi.Json

/**
 * Created by kokushiseiya on 2018/01/26.
 */
data class Images(
        @Json(name = "fixed_height")
        val fixedHeight: FixedHeight,
        @Json(name = "fixed_height_still")
        val fixedHeightStill: FixedHeightStill,
        @Json(name = "fixed_height_downsampled")
        val fixedHeightDownsampled: FixedHeightDownsampled,
        @Json(name = "fixed_width")
        val fixedWidth: FixedWidth,
        @Json(name = "fixed_width_still")
        val fixedWidthStill: FixedWidthStill,
        @Json(name = "fixed_width_downsampled")
        val fixedWidthDownsampled: FixedWidthDownsampled,
        @Json(name = "fixed_height_small")
        val fixedHeightSmall: FixedHeightSmall,
        @Json(name = "fixed_height_small_still")
        val fixedHeightSmallStill: FixedHeightSmallStill,
        @Json(name = "fixed_width_small")
        val fixedWidthSmall: FixedWidthSmall,
        @Json(name = "fixed_width_small_still")
        val fixedWidthSmallStill: FixedWidthSmallStill,
        val downsized: Downsized,
        @Json(name = "downsized_still")
        val downSizedStill: DownSizedStill,
        @Json(name = "downsized_large")
        val downsizedLarge: DownsizedLarge,
        @Json(name = "downsized_medium")
        val downsizedMedium: DownsizedMedium,
        @Json(name = "downsized_small")
        val downsizedSmall: DownsizedSmall,
        val original: Original,
        @Json(name = "original_still")
        val originalStill: OriginalStill,
        val looping: Looping,
        val preview: Preview,
        @Json(name = "preview_gif")
        val previewGif: PreviewGif
)