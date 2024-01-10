package com.contacts.sample.app.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.contacts.sample.app.ui.theme.AppTheme
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.app.ui.theme.SmallPadding
import com.contacts.sample.contacts.R

@Composable
internal fun ConnectionContent(isNetworkAvailable: Boolean) {
  val messageConnection =
    if (isNetworkAvailable) stringResource(id = R.string.online)
    else stringResource(id = R.string.offline)

  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = MaterialTheme.colorScheme.tertiary)
      .padding(vertical = SmallPadding, horizontal = MediumPadding),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    Text(
      text = messageConnection,
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

@Preview
@Composable
private fun ConnectionContentPreview(){
  AppTheme {
    ConnectionContent(isNetworkAvailable = false)
  }
}