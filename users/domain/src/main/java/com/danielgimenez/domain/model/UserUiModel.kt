package com.danielgimenez.domain.model

data class UserUiModel(
    val gender: String?,
    val name: Name?,
    val location: Location?,
    val email: String?,
    val dob: Dob?,
    val phone: String?,
    val cell: String?,
    val id: Id?,
    val picture: Picture?,
    val nat: String?
)

data class Name(
    val title: String?,
    val first: String?,
    val last: String?
)

data class Location(
    val street: Street,
    val city: String?,
    val state: String?,
    val country: String?,
    val postCode: Int?,
    val coordinates: Coordinates?,
    val timeZone: TimeZone?
)

data class Street(
    val number: Int?,
    val name: String?
)

data class Coordinates(
    val latitude: String?,
    val longitude: String?
)

data class TimeZone(
    val offset: String?,
    val description: String?
)

data class Dob(
    val date: String?,
    val age: Int?
)

data class Id(
    val name: String?,
    val value: String?
)

data class Picture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)

