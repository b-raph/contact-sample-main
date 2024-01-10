package com.contacts.sample.app.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.contacts.sample.app.ui.theme.AppTheme
import com.contacts.sample.app.ui.theme.CellSize
import com.contacts.sample.app.ui.theme.SmallPadding

@Composable
internal fun LoadingCell() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(CellSize)
      .padding(vertical = SmallPadding),
    contentAlignment = Alignment.Center
  ) {
    CircularProgressIndicator(
      modifier = Modifier.align(Alignment.Center),
      color = MaterialTheme.colorScheme.tertiary
    )
  }
}

@Preview
@Composable
private fun LoadingCellPreview() {
  AppTheme {
    LoadingCell()
  }
}