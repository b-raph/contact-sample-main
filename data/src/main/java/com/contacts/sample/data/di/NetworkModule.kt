package com.contacts.sample.data.di

import com.contacts.sample.data.network.api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    fun provideApi() = api
}