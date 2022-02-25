package com.pedrocomitto.poc.ordercommand.domain.request

import java.util.UUID

data class CustomerRequest(
    val customerId: UUID,
    val name: String,
    val document: String
)
