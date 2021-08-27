package com.heathercronin.sample.coordinatorapp.coordinator.navigator

import android.os.Parcelable
import android.util.Log
import androidx.navigation.NavController
import javax.inject.Inject

class RootNavigator @Inject constructor(): Navigator {
    override var navController: NavController? = null

    override fun navigateTo(screen: Parcelable) {
        Log.d("heather", "not implemented yet")
    }
}