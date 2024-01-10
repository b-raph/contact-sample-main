package com.contacts.sample.domain.usecase

import android.util.Log
import androidx.paging.PagingData
import com.contacts.sample.domain.contacts.repository.ContactsRepository
import com.contacts.sample.domain.contacts.usecase.RetrieveContactsUseCase
import com.contacts.sample.domain.entity.Contact
import com.contacts.sample.domain.mock.contacts
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RetrieveContactsUseCaseTest {

  @MockK
  lateinit var contactsRepository: ContactsRepository

  private val testScope = UnconfinedTestDispatcher()

  private lateinit var retrieveContactsUseCase: RetrieveContactsUseCase

  @Before
  fun setup() {
    MockKAnnotations.init(this)
    mockkStatic(Log::class)
    retrieveContactsUseCase = RetrieveContactsUseCase(
      contactsRepository
    )
  }

  @Test
  fun `retrieve a paging contact when call repository ok`() = runBlocking(testScope) {
    val expected = PagingData.from(contacts)

    coEvery { contactsRepository.retrieveContacts() } returns flow { emit(expected) }

    var result = PagingData.empty<Contact>()
    retrieveContactsUseCase.execute().collect { result = it }

    Assert.assertEquals(expected, result)
  }

  @Test
  fun `retrieve a error when call repository ko`() = runBlocking(testScope) {
    val expected = PagingData.from(contacts)

    coEvery { contactsRepository.retrieveContacts() } returns flow { emit(expected) }

    var result = PagingData.empty<Contact>()
    retrieveContactsUseCase.execute().collect { result = it }

    Assert.assertEquals(expected, result)
  }
}