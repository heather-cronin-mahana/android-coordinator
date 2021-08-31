package com.heathercronin.sample.coordinatorapp.view.flowb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.FlowBCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowAScreen
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowBScreen
import com.heathercronin.sample.coordinatorapp.databinding.FragmentFlowbTwoBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding
import com.heathercronin.sample.coordinatorapp.view.BaseFragment
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentTwoViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentTwoViewModel
import javax.inject.Inject

class FlowBFragmentTwo: BaseFragment() {
    private val binding: FragmentFlowbTwoBinding by viewBinding(FragmentFlowbTwoBinding::bind)

    @Inject
    lateinit var coordinator: FlowBCoordinator

    private lateinit var viewModel: FlowBFragmentTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_flowb_two, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = coordinator.createViewModel(
            this,
            viewModelFactory,
            viewLifecycleOwner,
            FlowBScreen.ScreenTwo
        ) as FlowBFragmentTwoViewModel
    }
}