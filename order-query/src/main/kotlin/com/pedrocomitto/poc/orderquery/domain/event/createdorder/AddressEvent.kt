package com.pedrocomitto.poc.orderquery.domain.event.createdorder

data class AddressEvent(
    val description: String,
    val number: String,
    val zipCode: String,
)