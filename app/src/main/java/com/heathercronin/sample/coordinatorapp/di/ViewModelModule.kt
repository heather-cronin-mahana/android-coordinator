package com.heathercronin.sample.coordinatorapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heathercronin.sample.coordinatorapp.di.annotations.ViewModelKey
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentOneViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentTwoViewModel
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
    abstract fun bindRootFragmentViewModel(viewModel: RootFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FlowAFragmentOneViewModel::class)
    abstract fun bindFlowAFragmentOneViewModel(viewModel: FlowAFragmentOneViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FlowAFragmentTwoViewModel::class)
    abstract fun bindFlowAFragmentTwoViewModel(viewModel: FlowAFragmentTwoViewModel): ViewModel
}