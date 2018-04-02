package com.ronnnnn.androidsamples.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.ActivityMainBinding
import com.ronnnnn.androidsamples.ui.trending.TrendingFragment

/**
 * Created by kokushiseiya on 2018/02/07.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        savedInstanceState ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                    .add(R.id.parentConstraintLayout, TrendingFragment.createInstance())
                    .commit()
        }
    }
}