package com.heathercronin.sample.coordinatorapp.coordinator.contract

import android.os.Parcelable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController

interface Coordinator <S: Parcelable, T: CoordinatorStartDetails> {
    var completionAction: (() -> Unit)?

    /**
     * Use this to display the first screen in a flow
     */
    fun start(params: T, completionAction: (() -> Unit)? = null) {
        this.completionAction = completionAction
    }

    /**
     * Create a viewmodel instance for the given screen
     */
    fun createViewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        viewModelFactory: ViewModelProvider.Factory,
        lifecycleOwner: LifecycleOwner,
        screen: S
    ): ViewModel?

    fun updateNavControllerOnViewCreated(navController: NavController)

    fun clearNavController(navController: NavController)

    fun finish() {
        completionAction?.invoke()
    }
}