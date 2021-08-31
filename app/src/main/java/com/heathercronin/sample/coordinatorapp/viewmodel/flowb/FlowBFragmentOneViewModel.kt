package com.heathercronin.sample.coordinatorapp.viewmodel.flowb

import androidx.lifecycle.ViewModel
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.FlowAScreenOneViewModelDelegate
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.FlowBScreenOneViewModelDelegate
import javax.inject.Inject

class FlowBFragmentOneViewModel @Inject constructor(): ViewModel() {
    var delegate: FlowBScreenOneViewModelDelegate? = null

    fun buttonClicked() {
        delegate?.nextButtonClicked()
    }
}