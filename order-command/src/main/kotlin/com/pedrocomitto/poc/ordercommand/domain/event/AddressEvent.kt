package com.pedrocomitto.poc.ordercommand.domain.event

data class AddressEvent(
    val description: String,
    val number: String,
    val zipCode: String,
)