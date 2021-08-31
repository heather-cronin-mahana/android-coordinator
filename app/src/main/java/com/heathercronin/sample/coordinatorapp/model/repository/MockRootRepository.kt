package com.heathercronin.sample.coordinatorapp.model.repository

import com.heathercronin.sample.coordinatorapp.model.data.ButtonModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MockRootRepository @Inject constructor(): RootRepository {
    override fun getData(): Observable<List<ButtonModel>> =
        Observable.create {
            it.onNext(
                listOf(
                    ButtonModel("Launch Flow A"),
                    ButtonModel("Launch Flow B")
                )
            )
        }
}