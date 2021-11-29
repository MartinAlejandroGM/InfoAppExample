package com.example.infoappexample.model

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    var results: ArrayList<InfoResults> = arrayListOf(),
    var info: Info = Info(),
    var error: String = ""
)

data class InfoResults(
    var gender: String = "",
    var name: Name = Name(),
    var location: Location = Location(),
    var email: String = "",
    var login: Login = Login(),
    var dob: Dob = Dob(),
    var registered: Registered = Registered(),
    var phone: String = "",
    var cell: String = "",
    var id: ID = ID(),
    var picture: Picture = Picture(),
    var nat: String = ""
)

data class Name(
    var tittle: String = "",
    @SerializedName("first")
    var firstName: String = "",
    @SerializedName("last")
    var lastName: String = ""
)

data class Location(
    var street: Street = Street(),
    var city: String = "",
    var state: String = "",
    var country: String = "",
    var postCode: String = "",
    var coordinates: Coordinates = Coordinates(),
    var timezone: Timezone = Timezone()
)

data class Street(
    var number: Int = 0,
    var name: String = ""
)

data class Coordinates(
    var latitude: String = "",
    var longitude: String = ""
)

data class Timezone(
    var offset: String = "",
    var description: String = ""
)

data class Login(
    var uuid: String = "",
    @SerializedName("username")
    var userName: String = "",
    var password: String = "",
    var salt: String = "",
    var md5: String = "",
    var sha1: String = "",
    var sha256: String = ""
)

data class Dob(
    var date: String = "",
    var age: Int = 0
)

data class Registered(
    var date: String = "",
    var age: Int = 0
)

data class ID(
    var name: String = "",
    var value: String? = null
)

data class Picture(
    var large: String = "",
    var medium: String = "",
    var thumbnail: String = ""
)

data class Info(
    var seed: String = "",
    var results: Int = 0,
    var page: Int = 0,
    var version: String = ""
)