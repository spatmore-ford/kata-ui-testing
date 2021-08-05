package com.ford.uitesting3_mockserver.data.models.api

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
)

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo,
)

data class Geo(
    val lat: Double,
    val lng: Double,
)
