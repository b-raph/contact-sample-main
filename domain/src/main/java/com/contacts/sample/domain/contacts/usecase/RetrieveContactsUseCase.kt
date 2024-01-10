package com.contacts.sample.domain.contacts.usecase

import androidx.paging.PagingData
import com.contacts.sample.domain.contacts.repository.ContactsRepository
import com.contacts.sample.domain.entity.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveContactsUseCase @Inject constructor(
  private val contactsRepository: ContactsRepository
) {

  fun execute(): Flow<PagingData<Contact>> {
    return contactsRepository.retrieveContacts()
  }
}