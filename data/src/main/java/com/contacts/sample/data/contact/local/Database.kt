package com.contacts.sample.data.contact.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.contacts.sample.data.contact.dao.ContactDao

@Database(
  entities = [ContactEntry::class],
  version = 1,
  exportSchema = false
)
abstract class Database : RoomDatabase() {
  abstract fun contactsDao(): ContactDao
}