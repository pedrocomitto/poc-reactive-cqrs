package com.pedrocomitto.poc.ordercommand.domain.event

data class OrderItemEvent(
    val id: Long,
    val description: String,
    val quantity: Int,
)