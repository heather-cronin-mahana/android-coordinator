package com.heathercronin.sample.coordinatorapp.coordinator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import com.heathercronin.sample.coordinatorapp.coordinator.contract.Coordinator
import com.heathercronin.sample.coordinatorapp.coordinator.contract.CoordinatorStartNoParams
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.FlowBScreenOneViewModelDelegate
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.FlowBNavigator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowBScreen
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentOneViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.flowb.FlowBFragmentTwoViewModel
import javax.inject.Inject

class FlowBCoordinator @Inject constructor(
    val navigator: FlowBNavigator
): Coordinator<FlowBScreen, CoordinatorStartNoParams>, FlowBScreenOneViewModelDelegate {
    override var completionAction: (() -> Unit)? = null

    override fun start(params: CoordinatorStartNoParams, completionAction: (() -> Unit)?) {
        super.start(params, completionAction)
        navigator.navigateTo(FlowBScreen.ScreenOne)
    }

    override fun createViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        lifecycleOwner: LifecycleOwner,
        screen: FlowBScreen
    ): ViewModel {
        return when (screen) {
            FlowBScreen.ScreenOne -> {
                ViewModelProvider(viewModelStoreOwner, viewModelFactory)
                    .get(FlowBFragmentOneViewModel::class.java).apply {
                        delegate = this@FlowBCoordinator
                    }
            }
            FlowBScreen.ScreenTwo -> {
                ViewModelProvider(viewModelStoreOwner, viewModelFactory)
                    .get(FlowBFragmentTwoViewModel::class.java).apply {
                        // assign any delegates here
                    }
            }
        }
    }

    override fun updateNavControllerOnViewCreated(navController: NavController) {
        navigator.updateNavController(navController)
    }

    override fun clearNavController(navController: NavController) {
        navigator.updateNavController(navController)
    }

    ///////// FlowAScreenOneViewModelDelegate Implementation
    override fun nextButtonClicked() {
        navigator.navigateTo(FlowBScreen.ScreenTwo)
    }
}