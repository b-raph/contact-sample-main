package com.contacts.sample.data.network

import com.contacts.sample.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://randomuser.me"

private val retrofit: Retrofit
    get() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val api: ApiService = retrofit.create(ApiService::class.java)