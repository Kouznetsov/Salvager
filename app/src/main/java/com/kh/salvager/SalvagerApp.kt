package com.kh.salvager

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SalvagerApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}