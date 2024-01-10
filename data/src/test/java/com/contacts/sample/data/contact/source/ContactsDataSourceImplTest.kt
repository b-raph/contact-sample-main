package com.contacts.sample.data.contact.source

import android.util.Log
import com.contacts.sample.data.api.ApiService
import com.contacts.sample.data.contact.dao.ContactDao
import com.contacts.sample.data.mock.contacts
import com.contacts.sample.data.mock.contactsDto
import com.contacts.sample.data.mock.contactsEntries
import com.contacts.sample.data.network.NetworkMonitor
import com.contacts.sample.domain.Constant.PAGE_SIZE
import com.contacts.sample.domain.contacts.source.ContactsDataSource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ContactsDataSourceImplTest {

  @MockK
  lateinit var contactDao: ContactDao

  @MockK
  lateinit var apiService: ApiService

  @MockK
  lateinit var networkMonitor: NetworkMonitor

  private val testScope = UnconfinedTestDispatcher()

  private lateinit var contactsDataSource: ContactsDataSource

  @Before
  fun setup() {
    MockKAnnotations.init(this, relaxUnitFun = true)
    mockkStatic(Log::class)
    contactsDataSource = ContactsDataSourceImpl(apiService, contactDao, networkMonitor)
  }

  @Test
  fun `test retrieve contacts when api is ok`() =
    runTest(testScope) {
      val expected = contacts
      coEvery { networkMonitor.getInitializedIsConnected() } returns true
      coEvery {
        apiService.retrieveContacts(
          results = PAGE_SIZE,
          page = 1
        )
      } returns contactsDto

      val result = contactsDataSource.retrieveContacts(page = 1)

      coVerify(exactly = 1) {
        contactsDataSource.insertContacts(
          contacts = contacts,
          indexBase = 20
        )
      }
      Assert.assertEquals(expected, result)
    }

  @Test
  fun `test retrieve contacts  when dao is ok`() =
    runTest(testScope) {
      val expected = contacts
      coEvery { networkMonitor.getInitializedIsConnected() } returns false
      coEvery {
        contactDao.getAllContacts(offset = 0, limit = PAGE_SIZE)
      } returns contactsEntries


      val result = contactsDataSource.retrieveContacts(page = 1)

      Assert.assertEquals(expected, result)
    }

}