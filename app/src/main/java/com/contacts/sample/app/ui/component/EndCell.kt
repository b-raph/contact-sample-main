package com.contacts.sample.app.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.contacts.sample.app.ui.theme.AppTheme
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.contacts.R

@Composable
internal fun EndCell() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = MediumPadding),
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = stringResource(id = R.string.end_text),
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSecondary,
      textAlign = TextAlign.Center
    )
  }
}

@Preview
@Composable
private fun EndCellPreview() {
  AppTheme {
    EndCell()
  }
}