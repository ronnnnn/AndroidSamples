package com.ronnnnn.androidsamples.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ronnnnn.androidsamples.ui.trending.TrendingFragment

class MainFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = Page.values()[position].getFragment()

    override fun getCount(): Int = Page.values().size

    enum class Page {
        Trending {
            override fun getFragment(): Fragment = TrendingFragment.createInstance()
        }
        ;

        abstract fun getFragment(): Fragment
    }
}