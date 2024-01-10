package com.contacts.sample.domain.contacts.source

import com.contacts.sample.domain.entity.Contact

interface ContactsDataSource {
  suspend fun retrieveContacts(page: Int): List<Contact>
  suspend fun insertContacts(contacts: List<Contact>, indexBase: Int)
}