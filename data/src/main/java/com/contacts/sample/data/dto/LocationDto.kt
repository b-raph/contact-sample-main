package com.contacts.sample.data.dto

data class LocationDto(
    val street: StreetDto?= null,
    val city: String? = null,
    val country: String? = null
)