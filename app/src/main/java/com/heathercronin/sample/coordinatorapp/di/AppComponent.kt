package com.heathercronin.sample.coordinatorapp.di

import android.app.Application
import android.content.Context
import com.heathercronin.sample.coordinatorapp.CoordinatorApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ActivityBindings::class,
    FragmentBindings::class,
    CoordinatorModule::class,
    RepositoryModule::class,
    AndroidInjectionModule::class
])
interface ApplicationComponent: AndroidInjector<CoordinatorApplication> {
    fun inject(target: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: Application): Builder

        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}