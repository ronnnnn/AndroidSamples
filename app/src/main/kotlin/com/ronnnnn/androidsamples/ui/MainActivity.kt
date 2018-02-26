package com.ronnnnn.androidsamples.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.androidsamples.App
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.ActivityMainBinding
import com.ronnnnn.androidsamples.di.ActivityScope
import com.ronnnnn.androidsamples.di.AppComponent
import com.ronnnnn.androidsamples.ui.bindingadapter.load
import com.ronnnnn.androidsamples.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/07.
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component: Component by lazy {
        DaggerMainActivity_Component.builder()
                .appComponent(App.get(this).appComponent)
                .build()
    }
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            viewModel = mainViewModel
        }

        mainViewModel.imageUrl.observe(this, Observer {
            it ?: return@Observer
            binding.gifImageView.load(it)
        })

        mainViewModel.title.observe(this, Observer {
            it ?: return@Observer
            binding.titleTextView.text = it
        })
    }

    @ActivityScope
    @dagger.Component(dependencies = [AppComponent::class])
    interface Component {

        fun inject(activity: MainActivity)
    }
}