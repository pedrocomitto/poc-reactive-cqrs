package com.pedrocomitto.poc.ordercommand.domain.event.createdorder

import java.util.UUID

data class CustomerEvent(
    val customerId: UUID,
    val name: String,
    val document: String
)