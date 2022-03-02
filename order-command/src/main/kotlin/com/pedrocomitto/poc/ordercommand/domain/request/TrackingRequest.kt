package com.pedrocomitto.poc.ordercommand.domain.request

data class TrackingRequest(
    val statusCode: String,
    val status: String,
)