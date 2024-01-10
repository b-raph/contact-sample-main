package com.contacts.sample.app.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
internal fun ToolbarWithTitle(title: String) =
  Text(
    text = title,
    style = MaterialTheme.typography.titleLarge,
    textAlign = TextAlign.Center
  )
