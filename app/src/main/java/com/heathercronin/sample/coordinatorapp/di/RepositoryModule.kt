package com.heathercronin.sample.coordinatorapp.di

import com.heathercronin.sample.coordinatorapp.model.repository.MockRootRepository
import com.heathercronin.sample.coordinatorapp.model.repository.RootRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(): RootRepository = MockRootRepository()
}