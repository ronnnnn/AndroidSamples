package com.ronnnnn.androidsamples.ui.search

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
import com.ronnnnn.androidsamples.databinding.FragmentSearchBinding
import com.ronnnnn.androidsamples.di.AppComponent
import com.ronnnnn.androidsamples.di.FragmentScope
import com.ronnnnn.androidsamples.ui.main.MainViewModel
import com.ronnnnn.androidsamples.viewmodel.ViewModelFactory
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var binding: FragmentSearchBinding

    private val searchRecyclerAdapter: SearchRecyclerAdapter = SearchRecyclerAdapter()
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
    }
    private val component: Component by lazy {
        DaggerSearchFragment_Component.builder()
                .appComponent(App.get(requireContext()).appComponent)
                .build()
    }

    companion object {

        fun createInstance(): Fragment = SearchFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            DataBindingUtil.inflate<FragmentSearchBinding>(
                    inflater,
                    R.layout.fragment_search,
                    container,
                    false
            ).also {
                binding = it
            }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecyclerView.run {
            adapter = searchRecyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    @FragmentScope
    @dagger.Component(dependencies = [AppComponent::class])
    interface Component {

        fun inject(searchFragment: SearchFragment)
    }
}