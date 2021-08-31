package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.di.annotations.ActivityScope
import com.heathercronin.sample.coordinatorapp.di.flowb.FlowBActivityBindings
import com.heathercronin.sample.coordinatorapp.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FlowBActivityBindings::class
])
abstract class ActivityBindings {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}