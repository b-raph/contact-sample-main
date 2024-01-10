package com.contacts.sample.app.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.contacts.sample.data.network.NetworkMonitor
import com.contacts.sample.domain.contacts.usecase.RetrieveContactsUseCase
import com.contacts.sample.domain.entity.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
  private val retrieveContactsUseCase: RetrieveContactsUseCase,
  val networkMonitor: NetworkMonitor
) : ViewModel() {

  private val _contacts: MutableStateFlow<PagingData<Contact>> =
    MutableStateFlow(PagingData.empty())
  var contacts = _contacts.asStateFlow()

  fun retrieveContacts() {
    viewModelScope.launch {
      _contacts.emit(PagingData.empty())
      retrieveContactsUseCase.execute().cachedIn(viewModelScope).collect {
        _contacts.value = it
      }
    }
  }
}