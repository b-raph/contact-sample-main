package com.contacts.sample.app.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.contacts.sample.app.ui.theme.AppTheme

@Composable
internal fun ToolbarWithTitle(title: String) =
  Text(
    text = title,
    style = MaterialTheme.typography.titleLarge,
    textAlign = TextAlign.Center
  )

@Preview
@Composable
private fun ToolbarWithTitlePreview() {
  AppTheme {
    ToolbarWithTitle("Contacts")
  }
}
