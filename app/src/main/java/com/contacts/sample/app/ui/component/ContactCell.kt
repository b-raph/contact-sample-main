package com.contacts.sample.app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.contacts.sample.app.ui.theme.CellSize
import com.contacts.sample.app.ui.theme.LargePadding
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.app.ui.theme.SmallPadding
import com.contacts.sample.contacts.R

@Composable
internal fun ContactCell(
  modifier: Modifier,
  thumbnailUrl: String,
  firstName: String,
  lastName: String
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .height(CellSize)
      .padding(horizontal = MediumPadding, vertical = SmallPadding),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    AsyncImage(
      modifier = Modifier
        .size(CellSize)
        .clip(shape = CircleShape)
        .background(color = MaterialTheme.colorScheme.tertiary),
      model = ImageRequest.Builder(LocalContext.current)
        .data(thumbnailUrl)
        .build(),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      error = painterResource(id = R.drawable.ic_launcher_foreground),
      placeholder = painterResource(id = R.drawable.ic_launcher_foreground)
    )
    Spacer(modifier = Modifier.width(LargePadding))
    Text(
      text = "$firstName $lastName",
      style = MaterialTheme.typography.bodyLarge
    )
  }
}