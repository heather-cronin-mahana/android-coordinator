package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.view.flowa.FlowAFragmentOne
import com.heathercronin.sample.coordinatorapp.view.flowa.FlowAFragmentTwo
import com.heathercronin.sample.coordinatorapp.view.RootFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindings {
    @ContributesAndroidInjector
    abstract fun contributesRootFragment(): RootFragment

    @ContributesAndroidInjector
    abstract fun contributesFlowAFragmentOne(): FlowAFragmentOne

    @ContributesAndroidInjector
    abstract fun contributesFlowAFragmentTwo(): FlowAFragmentTwo
}