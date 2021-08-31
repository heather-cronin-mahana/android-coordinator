package com.heathercronin.sample.coordinatorapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.RootCoordinator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.RootScreen
import com.heathercronin.sample.coordinatorapp.databinding.FragmentRootBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding
import com.heathercronin.sample.coordinatorapp.viewmodel.RootFragmentViewModel
import javax.inject.Inject

class RootFragment: BaseFragment() {
    private val binding: FragmentRootBinding by viewBinding(FragmentRootBinding::bind)

    @Inject
    lateinit var coordinator: RootCoordinator

    private lateinit var viewModel: RootFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_root, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = coordinator.createViewModel(
            this,
            viewModelFactory,
            viewLifecycleOwner,
            RootScreen.Index
        ) as RootFragmentViewModel

        viewModel.buttonList.observe(viewLifecycleOwner) {
            binding.topButton.text = it[0].title
            binding.bottomButton.text = it[1].title
        }

        viewModel.fetchData()

        binding.topButton.setOnClickListener {
            Toast.makeText(it.context, binding.topButton.text, Toast.LENGTH_SHORT).show()
        }
        binding.bottomButton.setOnClickListener {
            Toast.makeText(it.context, binding.bottomButton.text, Toast.LENGTH_SHORT).show()
        }
    }
}