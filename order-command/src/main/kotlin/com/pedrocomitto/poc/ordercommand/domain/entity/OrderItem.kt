package com.pedrocomitto.poc.ordercommand.domain.entity

data class OrderItem(
    val id: Long,
    val description: String,
    val quantity: Int,
)