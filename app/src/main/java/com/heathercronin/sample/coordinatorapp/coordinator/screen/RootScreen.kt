package com.heathercronin.sample.coordinatorapp.coordinator.screen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class RootScreen: Parcelable {
    @Parcelize
    object Index: RootScreen()

    @Parcelize
    object FlowA: RootScreen()

    @Parcelize
    object FlowB: RootScreen()
}
