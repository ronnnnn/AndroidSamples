package com.ronnnnn.androidsamples.di

import dagger.releasablereferences.CanReleaseReferences
import javax.inject.Scope


/**
 * Created by kokushiseiya on 2018/02/12.
 */
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@CanReleaseReferences
@Scope
annotation class ActivityScope