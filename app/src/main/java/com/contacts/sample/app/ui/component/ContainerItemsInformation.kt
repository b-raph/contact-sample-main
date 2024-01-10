package com.contacts.sample.app.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.contacts.sample.app.ui.theme.BorderWith
import com.contacts.sample.app.ui.theme.MediumPadding
import com.contacts.sample.app.ui.theme.SHAPE
import com.contacts.sample.app.ui.theme.SmallPadding
import com.contacts.sample.domain.Constant


@Composable
internal fun ContainerItemsInformation(
  titleContainer: String,
  listInformation: List<Pair<String, String?>>
) {

  Spacer(modifier = Modifier.height(MediumPadding))
  Text(
    modifier = Modifier.fillMaxWidth(),
    text = titleContainer,
    style = MaterialTheme.typography.headlineSmall,
    textAlign = TextAlign.Left
  )
  Spacer(modifier = Modifier.height(SmallPadding))
  Column(
    modifier = Modifier
      .border(
        width = BorderWith,
        color = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(SHAPE)
      )
      .fillMaxWidth()
  ) {
    listInformation.forEach {
      ItemInformation(title = it.first, information = it.second ?: Constant.EMPTY_STRING)
    }
  }
}

@Composable
private fun ItemInformation(title: String, information: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        start = MediumPadding,
        end = MediumPadding,
        bottom = SmallPadding,
      ),
    horizontalArrangement = Arrangement.Start
  ) {
    Text(
      modifier = Modifier.padding(top = SmallPadding),
      text = title,
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSecondary
    )
    Spacer(modifier = Modifier.width(MediumPadding))
    Text(
      modifier = Modifier.padding(top = SmallPadding),
      text = information,
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onPrimary
    )
  }
}