package com.pedrocomitto.poc.ordercommand.domain.request

data class OrderItemRequest(
    val description: String,
    val code: String
)
