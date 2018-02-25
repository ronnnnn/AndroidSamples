package com.ronnnnn.androidsamples.ui.bindingadapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.ronnnnn.androidsamples.GlideApp

/**
 * Created by kokushiseiya on 2018/02/26.
 */

@BindingAdapter("imageUrl")
fun ImageView.load(imageUrl: String) {
    GlideApp.with(context)
            .load(imageUrl)
            .into(this)
}