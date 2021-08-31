package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.coordinator.FlowACoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.FlowBCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.RootCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.FlowANavigator
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.FlowBNavigator
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
    fun provideRootCoordinator(
        navigator: RootNavigator,
        flowACoordinator: FlowACoordinator,
        flowBCoordinator: FlowBCoordinator
    ): RootCoordinator = RootCoordinator(navigator, flowACoordinator, flowBCoordinator)

    // FLOW A
    @Provides
    @Singleton
    fun provideFlowANavigator(): FlowANavigator = FlowANavigator()

    @Provides
    @Singleton
    fun provideFlowACoordinator(navigator: FlowANavigator): FlowACoordinator =
        FlowACoordinator(navigator)

    // FLOW B
    @Provides
    @Singleton
    fun provideFlowBNavigator(): FlowBNavigator = FlowBNavigator()

    @Provides
    @Singleton
    fun provideFlowBCoordinator(navigator: FlowBNavigator): FlowBCoordinator =
        FlowBCoordinator(navigator)
}