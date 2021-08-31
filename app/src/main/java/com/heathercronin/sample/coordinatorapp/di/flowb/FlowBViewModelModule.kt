package com.heathercronin.sample.coordinatorapp.di.flowb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heathercronin.sample.coordinatorapp.di.annotations.ViewModelKey
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentOneViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentTwoViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.RootFragmentViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentOneViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentTwoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FlowBViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FlowBFragmentOneViewModel::class)
    abstract fun bindFlowBFragmentOneViewModel(viewModel: FlowBFragmentOneViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FlowBFragmentTwoViewModel::class)
    abstract fun bindFlowBFragmentTwoViewModel(viewModel: FlowBFragmentTwoViewModel): ViewModel
}