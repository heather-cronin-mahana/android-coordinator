package com.heathercronin.sample.coordinatorapp.di.flowb

import com.heathercronin.sample.coordinatorapp.view.flowa.FlowAFragmentOne
import com.heathercronin.sample.coordinatorapp.view.flowa.FlowAFragmentTwo
import com.heathercronin.sample.coordinatorapp.view.flowb.FlowBFragmentOne
import com.heathercronin.sample.coordinatorapp.view.flowb.FlowBFragmentTwo
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FlowBFragmentBindings {
    @ContributesAndroidInjector
    abstract fun contributesFlowBFragmentOne(): FlowBFragmentOne

    @ContributesAndroidInjector
    abstract fun contributesFlowBFragmentTwo(): FlowBFragmentTwo
}