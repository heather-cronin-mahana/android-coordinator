package com.heathercronin.sample.coordinatorapp.coordinator.navigator

import android.os.Parcelable
import android.util.Log
import androidx.navigation.NavController
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowAScreen
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowBScreen
import javax.inject.Inject

class FlowBNavigator @Inject constructor(): Navigator {
    override var navController: NavController? = null

    companion object {
        private const val ACTIVITY_ID_ROOT = R.id.flowBActivity
        private const val FRAGMENT_ID_TWO = R.id.flowBFragmentTwo
    }

    override fun navigateTo(screen: Parcelable) {
        if (screen is FlowBScreen) {
            when (screen) {
                FlowBScreen.ScreenOne -> {
                    navController?.navigate(
                        ACTIVITY_ID_ROOT,
                        null,
                        getNavOptions()
                    )
                }
                FlowBScreen.ScreenTwo -> {
                    navController?.navigate(
                        FRAGMENT_ID_TWO,
                        null,
                        getNavOptions()
                    )
                }
            }
        }
    }
}