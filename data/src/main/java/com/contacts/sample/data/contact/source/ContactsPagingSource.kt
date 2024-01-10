package com.contacts.sample.data.contact.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.contacts.sample.domain.contacts.source.ContactsDataSource
import com.contacts.sample.domain.entity.Contact
import javax.inject.Inject

class ContactsPagingSource @Inject constructor(
  private val contactsDataSource: ContactsDataSource
) : PagingSource<Int, Contact>() {

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Contact> {
    return try {
      val nextPageNumber = params.key ?: 1
      val contacts = contactsDataSource.retrieveContacts(nextPageNumber)
      LoadResult.Page(
        data = contacts,
        prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
        nextKey = if (contacts.isEmpty()) null else nextPageNumber + 1
      )
    } catch (e: Exception) {
      LoadResult.Error(e)
    }
  }

  override fun getRefreshKey(state: PagingState<Int, Contact>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
    }
  }
}