package com.heathercronin.sample.coordinatorapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.databinding.FragmentRootBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding

class RootFragment: BaseFragment() {
    private val binding: FragmentRootBinding by viewBinding(FragmentRootBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_root, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.flowAButton.setOnClickListener {
            Toast.makeText(it.context, "Flow A", Toast.LENGTH_SHORT).show()
        }
        binding.flowBButton.setOnClickListener {
            Toast.makeText(it.context, "Flow B", Toast.LENGTH_SHORT).show()
        }
    }
}