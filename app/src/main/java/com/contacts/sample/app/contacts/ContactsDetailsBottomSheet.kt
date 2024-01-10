package com.contacts.sample.domain.contacts.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.contacts.sample.app.contacts.ContainersInformation
import com.contacts.sample.app.ui.component.LoadingCell
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.app.ui.theme.pictureSize
import com.contacts.sample.contacts.R
import com.contacts.sample.domain.entity.Contact

@Composable
internal fun ContactsDetailsBottomSheet(
  contacts: LazyPagingItems<Contact>,
  index: Int
) {
  if (contacts.itemCount != 0 && contacts.itemCount >= index) {
    val contact = contacts[index]
    Column(
      Modifier
        .navigationBarsPadding()
        .imePadding()
        .fillMaxSize()
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = MediumPadding)
          .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        AsyncImage(
          modifier = Modifier
            .size(pictureSize)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.tertiary),
          model = ImageRequest.Builder(LocalContext.current)
            .data(contact?.pictureUrl)
            .build(),
          contentDescription = null,
          contentScale = ContentScale.Crop,
          error = painterResource(id = R.drawable.ic_launcher_foreground),
          placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        )
        ContainersInformation(contact)
      }
    }
  } else {
    LoadingCell()
  }
}
