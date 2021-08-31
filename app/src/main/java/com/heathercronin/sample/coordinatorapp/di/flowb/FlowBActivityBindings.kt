package com.heathercronin.sample.coordinatorapp.di.flowb

import com.heathercronin.sample.coordinatorapp.di.annotations.ActivityScope
import com.heathercronin.sample.coordinatorapp.view.flowb.FlowBActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FlowBActivityBindings {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeFlowBActivity(): FlowBActivity
}