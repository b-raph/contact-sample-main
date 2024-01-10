package com.contacts.sample.data.mock

import com.contacts.sample.data.contact.local.ContactEntry
import com.contacts.sample.data.dto.*
import com.contacts.sample.domain.entity.Contact

private val contactDto1 = ContactDto(
  name = NameDto(title = "Mr", first = "Boby", last = "Dylan"),
  location = LocationDto(
    street = StreetDto(number = 234, name = "Wall street"),
    city = "New York",
    country = "Etats-unis"
  ),
  dob = DobDto(age = 32),
  picture = PictureDto(
    large = "https://picturelarge.com",
    thumbnail = "https://picturethumbnail.com"
  ),
  email = "boby.dylan@picture.com",
  cell = "432 234 3445"
)
private val contactDto2 = ContactDto(
  name = NameDto(title = "Mrs", first = "Ersa", last = "Scarlett"),
  location = LocationDto(
    street = StreetDto(number = 211, name = "Champs elysée"),
    city = "Paris",
    country = "France"
  ),
  dob = DobDto(age = 31),
  picture = PictureDto(
    large = "https://picturelarge.com",
    thumbnail = "https://picturethumbnail.com"
  ),
  email = "ersa.scalett@picture.com",
  cell = "2342 342 343"
)

val contactsDto = ContactsDto(listOf(contactDto1, contactDto2))

private val contact1 = Contact(
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


val contactDto3 = ContactDto(
  name = NameDto(title = "Mr", first = "Boby", last = "Dylan"),
  location = LocationDto(
    street = StreetDto(number = 234, name = "Wall street"),
    city = null,
    country = "Etats-unis"
  ),
  dob = DobDto(age = 32),
  picture = PictureDto(
    large = "https://picturelarge.com",
    thumbnail = "https://picturethumbnail.com"
  ),
  email = "boby.dylan@picture.com",
  cell = "432 234 3445"
)

val contact3 = Contact(
  title = "Mr",
  firstName = "Boby",
  lastName = "Dylan",
  age = "32",
  address = "234 Wall street",
  thumbnailUrl = "https://picturethumbnail.com",
  pictureUrl = "https://picturelarge.com",
  city = "",
  country = "Etats-unis",
  email = "boby.dylan@picture.com",
  phoneNumber = "432 234 3445"
)


private val contactEntries1 = ContactEntry(
  id = 0,
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
private val contactEntries2 = ContactEntry(
  id = 1,
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

val contactsEntries = listOf(contactEntries1, contactEntries2)