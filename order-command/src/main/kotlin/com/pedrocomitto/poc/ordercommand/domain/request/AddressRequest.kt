package com.pedrocomitto.poc.ordercommand.domain.request

data class AddressRequest(
    val description: String,
    val number: String,
    val zipCode: String,
)