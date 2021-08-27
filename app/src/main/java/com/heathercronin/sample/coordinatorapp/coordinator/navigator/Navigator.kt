package com.heathercronin.sample.coordinatorapp.coordinator.navigator

import android.os.Parcelable
import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * This interface will define the interface for each Navigator (the piece that is only responsible
 * for navigating between screens for a coordinator (in a singular flow)
 */
interface Navigator {
    var navController: NavController?

    fun navigateTo(screen: Parcelable)
    fun updateNavController(navController: NavController) {
        this.navController = navController
    }

    fun clearNavController(navController: NavController) {
        if (this.navController == navController) {
            this.navController = null
        }
    }

    fun getNavOptions(
        popToId: Int? = null,
        popIncludedDestination: Boolean = false
    ): NavOptions {
        val navOptionsBuilder = NavOptions.Builder()
            .setLaunchSingleTop(true)

        if (popToId != null) {
            navOptionsBuilder.setPopUpTo(popToId, popIncludedDestination)
        }

        return navOptionsBuilder.build()
    }
}