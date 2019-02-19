package com.example.haveibeenpwned.di

import com.example.haveibeenpwned.net.PwnService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetModule::class])
@Singleton
interface AppComponent {
    fun pwnService(): PwnService
}