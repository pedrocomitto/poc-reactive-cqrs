package com.pedrocomitto.poc.ordercommand.domain.event

data class OrderItemEvent(
    val description: String,
    val code: String
)