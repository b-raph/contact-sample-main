package com.contacts.sample.domain.contacts.repository

import androidx.paging.PagingData
import com.contacts.sample.domain.entity.Contact
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {

  fun retrieveContacts(): Flow<PagingData<Contact>>
}