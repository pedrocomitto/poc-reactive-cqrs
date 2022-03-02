package com.pedrocomitto.poc.orderquery.domain.event.createdorder

data class TrackingEvent(
    val code: String,
    val status: String
)