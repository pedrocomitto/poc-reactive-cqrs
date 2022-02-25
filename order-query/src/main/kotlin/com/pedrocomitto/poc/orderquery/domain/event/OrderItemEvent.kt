package com.pedrocomitto.poc.orderquery.domain.event

data class OrderItemEvent(
    val id: Long,
    val description: String,
    val quantity: Int,
)