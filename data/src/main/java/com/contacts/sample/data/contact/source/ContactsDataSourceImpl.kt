package com.contacts.sample.data.contact.source

import com.contacts.sample.data.api.ApiService
import com.contacts.sample.data.contact.dao.ContactDao
import com.contacts.sample.data.contact.mapper.toEntity
import com.contacts.sample.data.contact.mapper.toEntry
import com.contacts.sample.data.network.NetworkMonitor
import com.contacts.sample.domain.Constant
import com.contacts.sample.domain.contacts.source.ContactsDataSource
import com.contacts.sample.domain.entity.Contact
import javax.inject.Inject

class ContactsDataSourceImpl @Inject constructor(
  private val api: ApiService,
  private val contactDao: ContactDao,
  private val networkMonitor: NetworkMonitor
) : ContactsDataSource {

  override suspend fun retrieveContacts(page: Int): List<Contact> {
    val isConnected: Boolean = networkMonitor.getInitializedIsConnected()
    return if (isConnected) {
      val contacts =
        api.retrieveContacts(
          page = page,
          results = Constant.PAGE_SIZE
        ).results.map { it.toEntity() }
      insertContacts(contacts = contacts, indexBase = page * Constant.PAGE_SIZE)
      contacts
    } else {
      contactDao.getAllContacts(
        offset = (page - 1) * Constant.PAGE_SIZE,
        limit = Constant.PAGE_SIZE
      ).map { it.toEntry() }
    }
  }

  override suspend fun insertContacts(contacts: List<Contact>, indexBase: Int) {
    contactDao.insertAllContacts(contacts.mapIndexed { indexElement, contact ->
      contact.toEntry(index = indexElement + indexBase)
    })
  }
}