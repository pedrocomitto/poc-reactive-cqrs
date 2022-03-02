package com.pedrocomitto.poc.ordercommand.domain.event.createdorder

data class AddressEvent(
    val description: String,
    val number: String,
    val zipCode: String,
)