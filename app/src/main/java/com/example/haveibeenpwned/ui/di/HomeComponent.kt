package com.example.haveibeenpwned.ui.di

import com.example.haveibeenpwned.MainActivity
import com.example.haveibeenpwned.di.AppComponent
import dagger.Component

@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}