package com.heathercronin.sample.coordinatorapp


import android.app.Activity
import androidx.fragment.app.Fragment
import com.heathercronin.sample.coordinatorapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class CoordinatorApplication: DaggerApplication() {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .app(this)
            .build()
        applicationComponent.inject(this)
        return applicationComponent
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}