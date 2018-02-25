package com.ronnnnn.androidsamples

import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import java.io.InputStream

/**
 * Created by kokushiseiya on 2018/02/26.
 */
@GlideModule
class AppGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        context ?: return
        builder ?: return

        builder.setMemoryCache(LruResourceCache(getMaxCacheSize(context)))
                .setDefaultRequestOptions(RequestOptions().format(DecodeFormat.DEFAULT))
                .setDefaultTransitionOptions(Bitmap::class.java, BitmapTransitionOptions.withCrossFade())
                .setDefaultTransitionOptions(Drawable::class.java, DrawableTransitionOptions.withCrossFade())
    }

    override fun registerComponents(context: Context, glide: Glide?, registry: Registry?) {
        registry?.append(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    private fun getMaxCacheSize(context: Context): Int {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        return activityManager.memoryClass * 1024 * 1024 / 4
    }
}