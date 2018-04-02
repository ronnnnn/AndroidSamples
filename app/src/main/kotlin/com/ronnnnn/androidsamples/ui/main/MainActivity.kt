package com.ronnnnn.androidsamples.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.View
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
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.mainViewPager.run {
            adapter = MainFragmentPagerAdapter(supportFragmentManager)
            offscreenPageLimit = MainFragmentPagerAdapter.Page.values().size - 1
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {
                    // no-op
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    // no-op
                }

                override fun onPageSelected(position: Int) {
                    binding.mainBottomNavigationView.selectedItemId =
                            MainFragmentPagerAdapter.Page.values()[position].itemId

                    binding.mainSearchView.visibility =
                            if (position == MainFragmentPagerAdapter.Page.Search.ordinal) {
                                binding.mainSearchView.requestFocus()
                                View.VISIBLE
                            } else {
                                binding.mainSearchView.clearFocus()
                                View.INVISIBLE
                            }
                }
            })
        }

        binding.mainBottomNavigationView
                .setOnNavigationItemSelectedListener({ menuItem ->
                    val currentPosition = when (menuItem.itemId) {
                        MainFragmentPagerAdapter.Page.Trending.itemId -> 0
                        MainFragmentPagerAdapter.Page.Search.itemId -> 1
                        MainFragmentPagerAdapter.Page.Favorite.itemId -> 2
                        else -> throw IllegalStateException("invalid position")
                    }
                    binding.mainViewPager.currentItem = currentPosition
                    if (currentPosition == MainFragmentPagerAdapter.Page.Search.ordinal) View.VISIBLE
                    else View.INVISIBLE

                    true
                })

        binding.mainSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query ?: return false

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = true

        })
    }

    @ActivityScope
    @dagger.Component(dependencies = [AppComponent::class])
    interface Component {

        fun inject(mainActivity: MainActivity)
    }
}