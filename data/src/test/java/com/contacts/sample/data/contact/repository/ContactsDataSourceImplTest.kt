package com.contacts.sample.data.contact.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.contacts.sample.data.api.ApiService
import com.contacts.sample.data.contact.dao.ContactDao
import com.contacts.sample.data.contact.source.ContactsDataSourceImpl
import com.contacts.sample.data.contact.source.ContactsPagingSource
import com.contacts.sample.data.mock.contacts
import com.contacts.sample.data.mock.contactsDto
import com.contacts.sample.data.network.NetworkMonitor
import com.contacts.sample.data.network.api
import com.contacts.sample.domain.Constant
import com.contacts.sample.domain.Constant.PAGE_SIZE
import com.contacts.sample.domain.contacts.repository.ContactsRepository
import com.contacts.sample.domain.contacts.source.ContactsDataSource
import com.contacts.sample.domain.entity.Contact
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ContactsDataSourceImpl {

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
  fun `test retrieve contacts data source when api is ok`() =
    runBlocking(testScope) {
      val expected = contacts
      coEvery { networkMonitor.getInitializedIsConnected() } returns true
      coEvery {
        apiService.retrieveContacts(
          results = PAGE_SIZE,
          page = 0
        )
      } returns contactsDto


      val result = contactsDataSource.retrieveContacts(page = 0)

      coVerify(exactly = 1) { contactsDataSource.insertContacts(contacts, 0) }
      Assert.assertEquals(expected, result)
    }

}