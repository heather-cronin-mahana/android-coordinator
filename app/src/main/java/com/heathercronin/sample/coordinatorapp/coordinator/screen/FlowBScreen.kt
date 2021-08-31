package com.heathercronin.sample.coordinatorapp.coordinator.screen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class FlowBScreen: Parcelable {
    @Parcelize
    object ScreenOne: FlowBScreen()

    @Parcelize
    object ScreenTwo: FlowBScreen()
}
