package com.ronnnnn.androidsamples.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ronnnnn.androidsamples.App
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.ActivityMainBinding
import com.ronnnnn.androidsamples.di.ActivityScope
import com.ronnnnn.androidsamples.di.AppComponent
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

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).run {
            viewModel = mainViewModel
        }
    }

    @ActivityScope
    @dagger.Component(dependencies = [AppComponent::class])
    interface Component {

        fun inject(activity: MainActivity)
    }
}