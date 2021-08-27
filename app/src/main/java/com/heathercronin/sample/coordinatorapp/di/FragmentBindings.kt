package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.view.RootFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {
    @ContributesAndroidInjector
    abstract fun contributesRootFragment(): RootFragment
}