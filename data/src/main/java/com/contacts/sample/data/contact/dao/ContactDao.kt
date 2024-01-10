package com.contacts.sample.data.contact.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.contacts.sample.data.contact.local.ContactEntry

@Dao
interface ContactDao {

  @Query("SELECT * FROM contacts ORDER BY id ASC LIMIT :limit OFFSET :offset")
  fun getAllContacts(offset: Int, limit: Int): List<ContactEntry>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAllContacts(contacts: List<ContactEntry>)

}