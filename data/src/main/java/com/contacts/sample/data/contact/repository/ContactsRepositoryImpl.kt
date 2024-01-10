package com.contacts.sample.data.contact.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.contacts.sample.data.contact.source.ContactsPagingSource
import com.contacts.sample.domain.Constant.PAGE_SIZE
import com.contacts.sample.domain.contacts.repository.ContactsRepository
import com.contacts.sample.domain.entity.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ContactsRepositoryImpl @Inject constructor(
  private val contactsPagingSource: ContactsPagingSource
) : ContactsRepository {

  override fun retrieveContacts(): Flow<PagingData<Contact>> {
    return Pager(
      config = PagingConfig(
        PAGE_SIZE, enablePlaceholders = true
      )
    ) {
      contactsPagingSource
    }.flow
  }
}