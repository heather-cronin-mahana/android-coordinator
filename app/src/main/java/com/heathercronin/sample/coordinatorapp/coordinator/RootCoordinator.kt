package com.heathercronin.sample.coordinatorapp.coordinator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import com.heathercronin.sample.coordinatorapp.coordinator.contract.Coordinator
import com.heathercronin.sample.coordinatorapp.coordinator.contract.CoordinatorStartNoParams
import com.heathercronin.sample.coordinatorapp.coordinator.navigator.RootNavigator
import com.heathercronin.sample.coordinatorapp.coordinator.screen.RootScreen
import com.heathercronin.sample.coordinatorapp.viewmodel.RootFragmentViewModel
import javax.inject.Inject

class RootCoordinator @Inject constructor(
    val navigator: RootNavigator
): Coordinator<RootScreen, CoordinatorStartNoParams> {
    override var completionAction: (() -> Unit)? = null

    override fun start(params: CoordinatorStartNoParams, completionAction: (() -> Unit)?) {
        super.start(params, completionAction)
        // navigate to any applicable screens here
    }

    override fun createViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        lifecycleOwner: LifecycleOwner,
        screen: RootScreen
    ): ViewModel? {
        return when (screen) {
            is RootScreen.Index -> {
                ViewModelProvider(viewModelStoreOwner, viewModelFactory)
                    .get(RootFragmentViewModel::class.java).apply {
                    // assign any delegates here
                }
            }
            else -> null
        }
    }

    override fun updateNavControllerOnViewCreated(navController: NavController) {
        navigator.updateNavController(navController)
    }

    override fun clearNavController(navController: NavController) {
        navigator.updateNavController(navController)
    }
}
