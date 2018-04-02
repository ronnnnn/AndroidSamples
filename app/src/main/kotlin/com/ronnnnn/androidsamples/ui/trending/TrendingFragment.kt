package com.ronnnnn.androidsamples.ui.trending

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ronnnnn.androidsamples.App
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.FragmentTrendingBinding
import com.ronnnnn.androidsamples.di.AppComponent
import com.ronnnnn.androidsamples.di.FragmentScope
import com.ronnnnn.androidsamples.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/03/21.
 */
class TrendingFragment : Fragment() {

    companion object {
        fun createInstance(): TrendingFragment = TrendingFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: FragmentTrendingBinding

    private val trendingRecyclerAdapter: TrendingRecyclerAdapter = TrendingRecyclerAdapter()
    private val component: Component by lazy {
        DaggerTrendingFragment_Component.builder()
                .appComponent(App.get(requireContext()).appComponent)
                .build()
    }
    private val viewModel: TrendingViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TrendingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentTrendingBinding>(inflater, R.layout.fragment_trending, container, false)
                    .also { binding = it }
                    .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.trendingRecyclerView.run {
            adapter = trendingRecyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.observeTrendingData()
                .observe(this, Observer { gifs ->
                    trendingRecyclerAdapter.submitList(gifs)
                })
    }

    @FragmentScope
    @dagger.Component(dependencies = [AppComponent::class])
    interface Component {

        fun inject(trendingFragment: TrendingFragment)
    }
}