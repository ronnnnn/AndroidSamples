package com.ronnnnn.androidsamples.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.ui.favorite.FavoriteFragment
import com.ronnnnn.androidsamples.ui.search.SearchFragment
import com.ronnnnn.androidsamples.ui.trending.TrendingFragment

class MainFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = Page.values()[position].getFragment()

    override fun getCount(): Int = Page.values().size

    enum class Page(val itemId: Int) {
        Trending(R.id.trending) {
            override fun getFragment(): Fragment = TrendingFragment.createInstance()
        },
        Search(R.id.search) {
            override fun getFragment(): Fragment = SearchFragment.createInstance()
        },
        Favorite(R.id.favorite) {
            override fun getFragment(): Fragment = FavoriteFragment.createInstance()
        }
        ;

        abstract fun getFragment(): Fragment
    }
}