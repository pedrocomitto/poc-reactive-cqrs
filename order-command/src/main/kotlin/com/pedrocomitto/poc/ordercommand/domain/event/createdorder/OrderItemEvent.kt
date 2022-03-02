package com.pedrocomitto.poc.ordercommand.domain.event.createdorder

data class OrderItemEvent(
    val description: String,
    val code: String
)