package com.contacts.sample.data.di

import com.contacts.sample.data.contact.source.ContactsDataSourceImpl
import com.contacts.sample.domain.contacts.source.ContactsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindContactsDataSource(dataSource: ContactsDataSourceImpl): ContactsDataSource
}