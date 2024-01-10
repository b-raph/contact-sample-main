package com.contacts.sample.data.di

import com.contacts.sample.data.contact.repository.ContactsRepositoryImpl
import com.contacts.sample.domain.contacts.repository.ContactsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindContactsRepository(repository: ContactsRepositoryImpl): ContactsRepository
}