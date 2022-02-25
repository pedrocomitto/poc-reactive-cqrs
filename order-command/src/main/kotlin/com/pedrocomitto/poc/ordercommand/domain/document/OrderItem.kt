package com.pedrocomitto.poc.ordercommand.domain.document

data class OrderItem(
    val id: Long,
    val description: String,
    val quantity: Int,
)