package com.contacts.sample.app.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.contacts.sample.app.ui.theme.AppTheme
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.app.ui.theme.SmallPadding
import com.contacts.sample.contacts.R

@Composable
internal fun ErrorCell(retry: () -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = MediumPadding, vertical = SmallPadding),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = stringResource(id = R.string.error_text),
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSecondary,
      textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(SmallPadding))
    OutlinedButton(onClick = retry) {
      Text(
        text = stringResource(id = R.string.error_offline_button),
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSecondary
      )
    }
  }
}

@Preview
@Composable
private fun ErrorCellPreview() {
  AppTheme {
    ErrorCell(retry = { })
  }
}