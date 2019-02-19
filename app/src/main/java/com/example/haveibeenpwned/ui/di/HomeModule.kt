package com.example.haveibeenpwned.ui.di

import com.example.haveibeenpwned.net.PwnService
import com.example.haveibeenpwned.ui.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    @HomeScope
    fun providesHomeViewModel(pwnService: PwnService) = HomeViewModel(pwnService)
}