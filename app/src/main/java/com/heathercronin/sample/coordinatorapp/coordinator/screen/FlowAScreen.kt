package com.heathercronin.sample.coordinatorapp.coordinator.screen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class FlowAScreen: Parcelable {
    @Parcelize
    object ScreenOne: FlowAScreen()

    @Parcelize
    object ScreenTwo: FlowAScreen()
}
