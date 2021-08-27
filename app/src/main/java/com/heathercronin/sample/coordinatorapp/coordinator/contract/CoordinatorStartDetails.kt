package com.heathercronin.sample.coordinatorapp.coordinator.contract

interface CoordinatorStartDetails {
    fun getStartType(): CoordinatorStartType
}

val NoParams = object : CoordinatorStartNoParams { }

interface CoordinatorStartWithParams<out T>: CoordinatorStartDetails {
    fun getParams(): T
    override fun getStartType(): CoordinatorStartType = CoordinatorStartType.PARAMS_REQUIRED
}

interface CoordinatorStartNoParams: CoordinatorStartDetails {
    override fun getStartType(): CoordinatorStartType = CoordinatorStartType.NO_PARAMS
}