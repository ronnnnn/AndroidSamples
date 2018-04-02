package com.ronnnnn.androidsamples.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.ronnnnn.androidsamples.domain.search.SearchUseCase
import com.ronnnnn.data.giphy.common.entity.Gif
import javax.inject.Inject

class MainViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {

    fun observeSearchData(query: String): LiveData<PagedList<Gif>> =
            searchUseCase.observe(query)
}