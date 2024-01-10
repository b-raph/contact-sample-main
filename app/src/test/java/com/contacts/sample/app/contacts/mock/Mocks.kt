package com.contacts.sample.app.contacts.mock

import com.contacts.sample.domain.entity.Contact


val contact1 = Contact(
  title = "Mr",
  firstName = "Boby",
  lastName = "Dylan",
  age = "32",
  address = "234 Wall street",
  thumbnailUrl = "https://picturethumbnail.com",
  pictureUrl = "https://picturelarge.com",
  city = "New York",
  country = "Etats-unis",
  email = "boby.dylan@picture.com",
  phoneNumber = "432 234 3445"
)
private val contact2 = Contact(
  title = "Mrs",
  firstName = "Ersa",
  lastName = "Scarlett",
  age = "31",
  address = "211 Champs elysée",
  thumbnailUrl = "https://picturethumbnail.com",
  pictureUrl = "https://picturelarge.com",
  city = "Paris",
  country = "France",
  email = "ersa.scalett@picture.com",
  phoneNumber = "2342 342 343"
)

val contacts = listOf(contact1, contact2)