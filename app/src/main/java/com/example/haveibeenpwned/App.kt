package com.example.haveibeenpwned

import android.app.Application
import com.example.haveibeenpwned.di.AppComponent
import com.example.haveibeenpwned.di.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .build()

    }

    fun getAppComponent() = appComponent

}