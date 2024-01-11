package com.contacts.sample.app.contacts

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.contacts.sample.app.ui.component.ContainerItemsInformation
import com.contacts.sample.app.ui.theme.EndPadding
import com.contacts.sample.contacts.R
import com.contacts.sample.domain.Constant
import com.contacts.sample.domain.entity.Contact

@Composable
internal fun ContainersInformation(contact: Contact?) {
  PersonalDetails(contact)
  ContactDetails(contact)
  LocationDetails(contact)
  Spacer(modifier = Modifier.height(EndPadding))
}

@Composable
private fun LocationDetails(contact: Contact?) {
  val locationInformation = listOf(
    Pair(
      stringResource(id = R.string.contact_detail_information_address),
      contact?.address
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_city),
      contact?.city
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_country),
      contact?.country
    )
  )
  ContainerItemsInformation(
    titleContainer = stringResource(id = R.string.contact_detail_information_location),
    listInformation = locationInformation
  )
}

@Composable
private fun ContactDetails(contact: Contact?) {
  val contactsInformation = listOf(
    Pair(
      stringResource(id = R.string.contact_detail_information_phone_number),
      contact?.phoneNumber
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_mail),
      contact?.email
    )
  )
  ContainerItemsInformation(
    titleContainer = stringResource(id = R.string.contact_detail_information_contact),
    listInformation = contactsInformation
  )
}

@Composable
private fun PersonalDetails(contact: Contact?) {
  val personalDetailsInformation = listOf(
    Pair(
      stringResource(id = R.string.contact_detail_information_title),
      contact?.title
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_firstname),
      contact?.firstName
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_lastname),
      contact?.lastName
    ),
    Pair(
      stringResource(id = R.string.contact_detail_information_age),
      stringResource(
        id = R.string.contact_detail_information_age_information,
        contact?.age ?: Constant.EMPTY_STRING
      )
    )
  )
  ContainerItemsInformation(
    titleContainer = stringResource(id = R.string.contact_detail_information_personal_details),
    listInformation = personalDetailsInformation
  )
}