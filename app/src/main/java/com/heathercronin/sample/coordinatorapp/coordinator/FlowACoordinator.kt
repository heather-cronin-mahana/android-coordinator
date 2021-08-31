package com.heathercronin.sample.coordinatorapp.coordinator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import com.heathercronin.sample.coordinatorapp.coordinator.contract.Coordinator
import com.heathercronin.sample.coordinatorapp.coordinator.contract.CoordinatorStartNoParams
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.FlowAScreenOneViewModelDelegate
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.FlowANavigator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowAScreen
import com.heathercronin.sample.coordinatorapp.viewmodel.FlowAFragmentOneViewModel
import com.heathercronin.sample.coordinatorapp.viewmodel.FlowAFragmentTwoViewModel
import javax.inject.Inject

class FlowACoordinator @Inject constructor(
    val navigator: FlowANavigator
): Coordinator<FlowAScreen, CoordinatorStartNoParams>, FlowAScreenOneViewModelDelegate {
    override var completionAction: (() -> Unit)? = null

    override fun start(params: CoordinatorStartNoParams, completionAction: (() -> Unit)?) {
        super.start(params, completionAction)
        navigator.navigateTo(FlowAScreen.ScreenOne)
    }

    override fun createViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        lifecycleOwner: LifecycleOwner,
        screen: FlowAScreen
    ): ViewModel {
        return when (screen) {
            FlowAScreen.ScreenOne -> {
                ViewModelProvider(viewModelStoreOwner, viewModelFactory)
                    .get(FlowAFragmentOneViewModel::class.java).apply {
                        delegate = this@FlowACoordinator
                    }
            }
            FlowAScreen.ScreenTwo -> {
                ViewModelProvider(viewModelStoreOwner, viewModelFactory)
                    .get(FlowAFragmentTwoViewModel::class.java).apply {
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
        navigator.navigateTo(FlowAScreen.ScreenTwo)
    }
}