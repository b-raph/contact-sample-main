package com.contacts.sample.app.contacts

import androidx.paging.PagingData
import androidx.paging.map
import com.contacts.sample.app.contacts.mock.contact1
import com.contacts.sample.app.contacts.mock.contacts
import com.contacts.sample.data.network.NetworkMonitor
import com.contacts.sample.domain.contacts.usecase.RetrieveContactsUseCase
import com.contacts.sample.domain.entity.Contact
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ContactsViewModelTest {

  @MockK
  lateinit var retrieveContactsUseCase: RetrieveContactsUseCase

  @MockK
  lateinit var networkMonitor: NetworkMonitor

  private val testScope = UnconfinedTestDispatcher()

  private lateinit var contactsViewModel: ContactsViewModel

  @Before
  fun setup() {
    MockKAnnotations.init(this)
    contactsViewModel = ContactsViewModel(
      retrieveContactsUseCase = retrieveContactsUseCase,
      networkMonitor = networkMonitor
    )
  }

  @Test
  fun `test retrieve contacts when use case is ok `() = runTest(testScope) {
    val expected = listOf(contact1)

    coEvery { retrieveContactsUseCase.execute() } returns flow {
      emit(
        PagingData.from(
          listOf(
            contact1
          )
        )
      )
    }
    val result = mutableListOf<Contact>()
    val job =
      contactsViewModel.contacts.onEach { result.addAll(it) }.launchIn(this)

    contactsViewModel.retrieveContacts()

    advanceUntilIdle()
    Assert.assertEquals(expected, result)
    job.cancel()
  }
}