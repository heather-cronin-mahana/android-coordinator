package com.heathercronin.sample.coordinatorapp.coordinator.navigator

import android.os.Parcelable
import android.util.Log
import androidx.navigation.NavController
import com.heathercronin.sample.coordinatorapp.R
import com.heathercronin.sample.coordinatorapp.coordinator.screen.FlowAScreen
import javax.inject.Inject

class FlowANavigator @Inject constructor(): Navigator {
    override var navController: NavController? = null

    companion object {
        private const val FRAGMENT_ID_ONE = R.id.flowAFragmentOne
        private const val FRAGMENT_ID_TWO = R.id.flowAFragmentTwo
    }

    override fun navigateTo(screen: Parcelable) {
        if (screen is FlowAScreen) {
            when (screen) {
                FlowAScreen.ScreenOne -> {
                    navController?.navigate(
                        FRAGMENT_ID_ONE,
                        null,
                        getNavOptions()
                    )
                }
                FlowAScreen.ScreenTwo -> {
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