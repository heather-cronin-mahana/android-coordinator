package com.heathercronin.sample.coordinatorapp.model.repository

import com.heathercronin.sample.coordinatorapp.model.data.ButtonModel
import io.reactivex.rxjava3.core.Observable

interface RootRepository {
    fun getData(): Observable<List<ButtonModel>>
}