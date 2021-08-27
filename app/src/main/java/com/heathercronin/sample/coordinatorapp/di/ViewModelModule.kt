package com.heathercronin.sample.coordinatorapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heathercronin.sample.coordinatorapp.di.annotations.ViewModelKey
import com.heathercronin.sample.coordinatorapp.viewmodel.RootFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bind(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RootFragmentViewModel::class)
    abstract fun bindMainViewModel(viewModel: RootFragmentViewModel): ViewModel
}