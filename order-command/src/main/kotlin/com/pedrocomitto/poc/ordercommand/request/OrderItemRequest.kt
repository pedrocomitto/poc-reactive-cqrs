package com.pedrocomitto.poc.ordercommand.request

data class OrderItemRequest(
    val id: Long,
    val description: String,
    val quantity: Int,
)