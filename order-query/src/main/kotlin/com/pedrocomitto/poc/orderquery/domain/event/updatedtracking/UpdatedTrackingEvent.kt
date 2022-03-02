package com.pedrocomitto.poc.orderquery.domain.event.updatedtracking

data class UpdatedTrackingEvent(
    val orderId: Long,
    val code: String,
    val status: String
)