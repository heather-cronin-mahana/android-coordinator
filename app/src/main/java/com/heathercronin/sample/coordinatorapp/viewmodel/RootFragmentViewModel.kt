package com.heathercronin.sample.coordinatorapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heathercronin.sample.coordinatorapp.coordinator.delegate.RootScreenViewModelDelegate
import com.heathercronin.sample.coordinatorapp.model.data.ButtonModel
import com.heathercronin.sample.coordinatorapp.model.repository.RootRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class RootFragmentViewModel @Inject constructor(
    val repository: RootRepository
): ViewModel() {
    var delegate: RootScreenViewModelDelegate? = null

    private val mutableButtonList = MutableLiveData<List<ButtonModel>>()
    val buttonList = mutableButtonList as LiveData<List<ButtonModel>>

    val compositeDisposable = CompositeDisposable()

    fun fetchData() {
        val dataDisposable = repository.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mutableButtonList.value = it
                }, {
                    Log.e(TAG, it.stackTraceToString())
                })
        compositeDisposable.add(dataDisposable)
    }

    fun topButtonClick() {
        delegate?.topButtonClicked()
    }

    companion object {
        private val TAG = RootFragmentViewModel::class.simpleName
    }
}