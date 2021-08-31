package com.heathercronin.sample.coordinatorapp.viewmodel

import androidx.lifecycle.ViewModel
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.FlowAScreenOneViewModelDelegate
import javax.inject.Inject

class FlowAFragmentOneViewModel @Inject constructor(): ViewModel() {
    var delegate: FlowAScreenOneViewModelDelegate? = null

    fun buttonClicked() {
        delegate?.nextButtonClicked()
    }
}