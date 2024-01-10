package com.contacts.sample.data.contact.mapper

import com.contacts.sample.data.contact.local.ContactEntry
import com.contacts.sample.data.dto.ContactDto
import com.contacts.sample.domain.Constant.EMPTY_STRING
import com.contacts.sample.domain.entity.Contact

fun ContactDto.toEntity() = Contact(
  title = this.name?.title ?: EMPTY_STRING,
  firstName = this.name?.first ?: EMPTY_STRING,
  lastName = this.name?.last ?: EMPTY_STRING,
  age = this.dob?.age.toString(),
  address = "${this.location?.street?.number} ${this.location?.street?.name}",
  thumbnailUrl = this.picture?.thumbnail ?: EMPTY_STRING,
  pictureUrl = this.picture?.large ?: EMPTY_STRING,
  city = this.location?.city ?: EMPTY_STRING,
  country = this.location?.country ?: EMPTY_STRING,
  email = this.email ?: EMPTY_STRING,
  phoneNumber = this.cell ?: EMPTY_STRING
)

fun Contact.toEntry(index: Int) = ContactEntry(
  id = index.toLong(),
  title = this.title,
  firstName = this.firstName,
  lastName = this.lastName,
  age = this.age,
  address = this.address,
  thumbnailUrl = this.thumbnailUrl,
  pictureUrl = this.pictureUrl,
  city = this.city,
  country = this.country,
  email = this.email,
  phoneNumber = this.phoneNumber
)

fun ContactEntry.toEntry() = Contact(
  title = this.title,
  firstName = this.firstName,
  lastName = this.lastName,
  age = this.age,
  address = this.address,
  thumbnailUrl = this.thumbnailUrl,
  pictureUrl = this.pictureUrl,
  city = this.city,
  country = this.country,
  email = this.email,
  phoneNumber = this.phoneNumber
)