package com.heathercronin.sample.coordinatorapp.view.flowb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.FlowBCoordinator
import com.heathercronin.sample.coordinatorapp.databinding.ActivityFlowbBinding
import com.heathercronin.sample.coordinatorapp.databinding.ActivityMainBinding
import com.heathercronin.sample.coordinatorapp.extensions.viewBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class FlowBActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var flowBCoordinator: FlowBCoordinator

    private val binding by viewBinding(ActivityFlowbBinding::inflate)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        flowBCoordinator.updateNavControllerOnViewCreated(navController)
    }
}