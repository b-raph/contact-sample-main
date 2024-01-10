package com.contacts.sample.data.contact.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntry(
  @PrimaryKey val id : Long,
  val title: String,
  val firstName: String,
  val lastName: String,
  val age: String,
  val address: String,
  val thumbnailUrl: String,
  val pictureUrl: String,
  val city: String,
  val country: String,
  val email: String,
  val phoneNumber: String
)