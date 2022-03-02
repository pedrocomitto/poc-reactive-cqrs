package com.pedrocomitto.poc.ordercommand.domain.event.updatedtracking

data class UpdatedTrackingEvent(
    val orderId: Long,
    val code: String,
    val status: String
)