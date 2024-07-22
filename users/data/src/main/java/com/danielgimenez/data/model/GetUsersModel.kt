package com.danielgimenez.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GetUsersModel(
    val results: ArrayList<UserModel>,
    val info: Info?
)

@Serializable
data class UserModel(
    val gender: String?,
    val name: Name?,
    val location: Location?,
    val email: String?,
    val dob: Dob,
    val phone: String?,
    val cell: String?,
    val id: Id?,
    val picture: Picture?,
    val nat: String?
)

@Serializable
data class Name(
    val title: String?,
    val first: String?,
    val last: String?
)

@Serializable
data class Location(
    val street: Street,
    val city: String?,
    val state: String?,
    val country: String?,
    val postcode: Int?,
    val coordinates: Coordinates?,
    val timezone: TimeZone?
)

@Serializable
data class Street(
    val number: Int?,
    val name: String?
)

@Serializable
data class Coordinates(
    val latitude: String?,
    val longitude: String?
)

@Serializable
data class TimeZone(
    val offset: String?,
    val description: String?
)

@Serializable
data class Dob(
    val date: String?,
    val age: Int?
)

@Serializable
data class Id(
    val name: String?,
    val value: String?
)

@Serializable
data class Picture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)

@Serializable
data class Info(
    val seed: String?,
    val results: Int?,
    val page: Int?,
    val version: String?
)
