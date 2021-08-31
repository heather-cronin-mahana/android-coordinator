package com.heathercronin.sample.coordinatorapp.view.flowb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.FlowBCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowBScreen
import com.heathercronin.sample.coordinatorapp.databinding.FragmentFlowaOneBinding
import com.heathercronin.sample.coordinatorapp.databinding.FragmentFlowbOneBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding
import com.heathercronin.sample.coordinatorapp.view.BaseFragment
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentOneViewModel
import javax.inject.Inject

class FlowBFragmentOne: BaseFragment() {
    private val binding: FragmentFlowbOneBinding by viewBinding(FragmentFlowbOneBinding::bind)

    @Inject
    lateinit var coordinator: FlowBCoordinator

    private lateinit var viewModel: FlowBFragmentOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_flowb_one, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = coordinator.createViewModel(
            this,
            viewModelFactory,
            viewLifecycleOwner,
            FlowBScreen.ScreenOne
        ) as FlowBFragmentOneViewModel
        binding.viewModel = viewModel
    }
}