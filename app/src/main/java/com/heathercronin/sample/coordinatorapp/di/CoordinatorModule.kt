package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.coordinator.RootCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.Navigator
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.RootNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoordinatorModule {
    @Provides
    @Singleton
    fun provideRootNavigator(): RootNavigator = RootNavigator()

    @Provides
    @Singleton
    fun provideRootCoordinator(navigator: RootNavigator): RootCoordinator = RootCoordinator(navigator)
}