package com.contacts.sample.data.contact.mapper

import com.contacts.sample.data.dto.ContactsDto
import com.contacts.sample.data.mock.contact3
import com.contacts.sample.data.mock.contactDto3
import com.contacts.sample.data.mock.contacts
import com.contacts.sample.data.mock.contactsDto
import com.contacts.sample.data.mock.contactsEntries
import io.mockk.MockKAnnotations
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContractsMapperTest {

  @Before
  fun setup() {
    MockKAnnotations.init(this)
  }

  @Test
  fun `map ContactDto in Contact`() = runTest {
    val expected = contacts
    val result = contactsDto.results.map { it.toEntity() }
    Assert.assertEquals(result, expected)
  }

  @Test
  fun `map ContactDto in Contact with null element`() = runTest {
    val expected = listOf(contact3)
    val result = ContactsDto(listOf(contactDto3)).results.map { it.toEntity() }
    Assert.assertEquals(result, expected)
  }

  @Test
  fun `map Contact in ContactEntry`() = runTest {
    val expected = contactsEntries
    val result = contacts.mapIndexed { index, contact -> contact.toEntry(index) }
    Assert.assertEquals(result, expected)
  }

  @Test
  fun `map ContactEntry in Contact`() = runTest {
    val expected = contacts
    val result = contactsEntries.map { it.toEntry() }
    Assert.assertEquals(result, expected)
  }
}