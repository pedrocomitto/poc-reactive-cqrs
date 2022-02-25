package com.pedrocomitto.poc.ordercommand.domain.event

data class TrackingEvent(
    val statusCode: String,
    val status: String
)