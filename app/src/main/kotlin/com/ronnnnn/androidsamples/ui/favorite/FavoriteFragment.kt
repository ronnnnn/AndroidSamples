package com.ronnnnn.androidsamples.ui.favorite

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    companion object {

        fun createInstance(): Fragment = FavoriteFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentFavoriteBinding>(inflater, R.layout.fragment_favorite, container, false).root
}