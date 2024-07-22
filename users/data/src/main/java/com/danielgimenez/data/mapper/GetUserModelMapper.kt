package com.danielgimenez.data.mapper

import com.danielgimenez.data.model.Coordinates
import com.danielgimenez.data.model.Dob
import com.danielgimenez.data.model.GetUsersModel
import com.danielgimenez.data.model.Id
import com.danielgimenez.data.model.Location
import com.danielgimenez.data.model.Name
import com.danielgimenez.data.model.Picture
import com.danielgimenez.data.model.Street
import com.danielgimenez.data.model.TimeZone
import com.danielgimenez.domain.model.UserUiModel

fun GetUsersModel.toUiModel() =
    results.map { result ->
        UserUiModel(
            gender = result.gender,
            name = result.name?.toUiModel(),
            location = result.location?.toUiModel(),
            email = result.email,
            dob = result.dob.toUiModel(),
            phone = result.phone,
            cell = result.cell,
            id = result.id?.toUiModel(),
            picture = result.picture?.toUiModel(),
            nat = result.nat
        )
    }

fun Name.toUiModel() =
    com.danielgimenez.domain.model.Name(
        title = this.title,
        first = this.first,
        last = this.last
    )

fun Location.toUiModel() =
    com.danielgimenez.domain.model.Location(
        street = this.street.toUiModel(),
        city = this.city,
        state = this.state,
        country = this.country,
        postCode = this.postcode,
        coordinates = this.coordinates?.toUiModel(),
        timeZone = this.timezone?.toUiModel()
    )

fun Street.toUiModel() =
    com.danielgimenez.domain.model.Street(
        number = this.number,
        name = this.name
    )

fun Coordinates.toUiModel() =
    com.danielgimenez.domain.model.Coordinates(
        longitude = this.longitude,
        latitude = this.latitude
    )

fun TimeZone.toUiModel() =
    com.danielgimenez.domain.model.TimeZone(
        offset = this.offset,
        description = this.description
    )

fun Dob.toUiModel() =
    com.danielgimenez.domain.model.Dob(
        date = this.date,
        age = this.age
    )

fun Id.toUiModel() =
    com.danielgimenez.domain.model.Id(
        name = this.name,
        value = this.value
    )

fun Picture.toUiModel() =
    com.danielgimenez.domain.model.Picture(
        large = this.large,
        medium = this.medium,
        thumbnail = this.thumbnail
    )

