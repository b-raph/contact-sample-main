package com.contacts.sample.app.contacts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.contacts.sample.app.ui.component.ConnectionContent
import com.contacts.sample.app.ui.component.ContactCell
import com.contacts.sample.app.ui.component.EndCell
import com.contacts.sample.app.ui.component.ErrorCell
import com.contacts.sample.app.ui.component.LoadingCell
import com.contacts.sample.app.ui.component.ToolbarWithTitle
import com.contacts.sample.app.ui.theme.BorderWith
import com.contacts.sample.contacts.R
import com.contacts.sample.domain.Constant.EMPTY_STRING
import com.contacts.sample.domain.contacts.contacts.ContactsDetailsBottomSheet
import com.contacts.sample.domain.entity.Contact

private const val INDEX_DEFAULT = 1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(
  viewModel: ContactsViewModel
) {
  val contactPagingItems: LazyPagingItems<Contact> =
    viewModel.contacts.collectAsLazyPagingItems()
  var indexDetailContact by remember {
    mutableIntStateOf(INDEX_DEFAULT)
  }
  val isNetworkAvailable by viewModel.networkMonitor.isConnectedFlow.collectAsState(initial = true)
  var showSheet by remember { mutableStateOf(false) }

  val modalBottomSheetState = rememberModalBottomSheetState(
    skipPartiallyExpanded = true,
    confirmValueChange = { it != SheetValue.PartiallyExpanded }
  )

  LaunchedEffect(isNetworkAvailable) {
    viewModel.retrieveContacts()
  }

  Scaffold(
    topBar = {
      CenterAlignedTopAppBar(
        modifier = Modifier.shadow(elevation = 4.dp),
        colors = TopAppBarColors(
          containerColor = Color.White,
          navigationIconContentColor = Color.Black,
          actionIconContentColor = Color.Black,
          scrolledContainerColor = Color.Black,
          titleContentColor = Color.Black
        ),
        title = {
          ToolbarWithTitle(stringResource(R.string.toolbar_title_contact))
        },
      )
    }
  ) {
    Box(modifier = Modifier.padding(it)) {
      ContactsContent(
        contactPagingItems = contactPagingItems,
        isNetworkAvailable = isNetworkAvailable,
        onOpenBottomSheet =
        { index ->
          indexDetailContact = index
          showSheet = true
        }
      )

      if (showSheet) {
        ModalBottomSheet(
          modifier = Modifier.statusBarsPadding(),
          onDismissRequest = { showSheet = false },
          sheetState = modalBottomSheetState,
          dragHandle = { BottomSheetDefaults.DragHandle() },
        ) {
          ContactsDetailsBottomSheet(
            contacts = contactPagingItems,
            index = indexDetailContact
          )
        }
      }
    }
  }
}

@Composable
private fun ContactsContent(
  modifier: Modifier = Modifier,
  isNetworkAvailable: Boolean,
  contactPagingItems: LazyPagingItems<Contact>,
  onOpenBottomSheet: (Int) -> Unit
) {
  LazyColumn(modifier = modifier) {
    item {
      ConnectionContent(isNetworkAvailable = isNetworkAvailable)
    }
    items(contactPagingItems.itemCount) { index ->
      ContactCell(
        modifier = Modifier.clickable { onOpenBottomSheet.invoke(index) },
        thumbnailUrl = contactPagingItems[index]?.thumbnailUrl ?: EMPTY_STRING,
        firstName = contactPagingItems[index]?.firstName ?: EMPTY_STRING,
        lastName = contactPagingItems[index]?.lastName ?: EMPTY_STRING
      )
      HorizontalDivider(
        modifier = Modifier.border(
          BorderStroke(BorderWith, color = MaterialTheme.colorScheme.tertiary)
        )
      )
    }

    contactPagingItems.apply {
      when {
        loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
          item {
            LoadingCell()
          }
        }

        loadState.append is LoadState.Error || loadState.refresh is LoadState.Error -> {
          item {
            ErrorCell(retry = { retry() })
          }
        }
      }
      if (loadState.append.endOfPaginationReached) {
        item {
          EndCell()
        }
      }
    }
  }
}