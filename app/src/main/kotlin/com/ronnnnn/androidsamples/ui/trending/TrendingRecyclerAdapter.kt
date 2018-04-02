package com.ronnnnn.androidsamples.ui.trending

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ronnnnn.androidsamples.R
import com.ronnnnn.androidsamples.databinding.ItemTrendingRecyclerViewBinding
import com.ronnnnn.data.giphy.common.entity.Gif

/**
 * Created by kokushiseiya on 2018/03/21.
 */
class TrendingRecyclerAdapter : PagedListAdapter<Gif, TrendingRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Gif>() {
            override fun areItemsTheSame(oldItem: Gif?, newItem: Gif?): Boolean =
                    oldItem == newItem

            override fun areContentsTheSame(oldItem: Gif?, newItem: Gif?): Boolean =
                    oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            DataBindingUtil.inflate<ItemTrendingRecyclerViewBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_trending_recycler_view,
                    parent,
                    false
            ).let { ViewHolder(it) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class ViewHolder(binding: ItemTrendingRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        private val imageUrl: ObservableField<String> = ObservableField("")

        init {
            binding.imageUrl = imageUrl
        }

        fun onBind(position: Int) {
            getItem(position)?.images?.fixedHeightSmall?.url?.let {
                imageUrl.set(it)
            }
        }
    }
}