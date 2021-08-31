package com.heathercronin.sample.coordinatorapp.view.flowa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.FlowACoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowAScreen
import com.heathercronin.sample.coordinatorapp.databinding.FragmentFlowaOneBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding
import com.heathercronin.sample.coordinatorapp.view.BaseFragment
import com.heathercronin.sample.coordinatorapp.viewmodel.flowa.FlowAFragmentOneViewModel
import javax.inject.Inject

class FlowAFragmentOne: BaseFragment() {
    private val binding: FragmentFlowaOneBinding by viewBinding(FragmentFlowaOneBinding::bind)

    @Inject
    lateinit var coordinator: FlowACoordinator

    private lateinit var viewModel: FlowAFragmentOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_flowa_one, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = coordinator.createViewModel(
            this,
            viewModelFactory,
            viewLifecycleOwner,
            FlowAScreen.ScreenOne
        ) as FlowAFragmentOneViewModel
        binding.viewModel = viewModel
    }
}