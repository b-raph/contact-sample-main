package com.contacts.sample.data.api

import com.contacts.sample.data.dto.ContactsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

  @GET("/api/1.3/")
  suspend fun retrieveContacts(
    @Query("seed") seed: String = "lydia",
    @Query("results") results: Int,
    @Query("page") page: Int,
  ): ContactsDto
}