package com.contacts.sample.data.di

import android.content.Context
import androidx.room.Room
import com.contacts.sample.data.contact.local.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

  private const val DATABASE_NAME = "Database"

  @Provides
  internal fun provideDatabase(@ApplicationContext context: Context) =
    Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
      .allowMainThreadQueries()
      .build()

  @Provides
  internal fun provideBookmarkDao(db: Database) = db.contactsDao()
}