package com.pedrocomitto.poc.ordercommand.domain.document

import java.util.UUID

data class Customer(
    val id: UUID,
    val name: String,
)