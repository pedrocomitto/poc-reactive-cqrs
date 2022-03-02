package com.pedrocomitto.poc.orderquery.domain.event.createdorder

data class OrderItemEvent(
    val description: String,
    val code: String
)