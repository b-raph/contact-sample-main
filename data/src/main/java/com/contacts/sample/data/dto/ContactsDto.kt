package com.contacts.sample.data.dto

data class ContactsDto(
    val results : List<ContactDto>
)

data class ContactDto(
    val name: NameDto? = null,
    val email: String? = null,
    val location: LocationDto? = null,
    val dob: DobDto? = null,
    val picture : PictureDto? = null,
    val cell : String? = null
)