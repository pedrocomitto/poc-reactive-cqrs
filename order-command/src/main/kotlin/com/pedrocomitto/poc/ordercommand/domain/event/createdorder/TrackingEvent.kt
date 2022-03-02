package com.pedrocomitto.poc.ordercommand.domain.event.createdorder

data class TrackingEvent(
    val code: String,
    val status: String
)