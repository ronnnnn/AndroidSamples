package com.ronnnnn.androidsamples.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2018/02/08.
 */
@Singleton
class ViewModelFactory @Inject constructor(
        private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
                ?: creators.entries.firstOrNull { (key) -> modelClass.isAssignableFrom(key) }?.value
                ?: throw IllegalArgumentException("Unknown ViewModel Class: $modelClass")

        @Suppress("UNCHECKED_CAST")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}