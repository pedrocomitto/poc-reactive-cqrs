package com.pedrocomitto.poc.ordercommand.domain.event

import java.util.UUID

data class CustomerEvent(
    val id: UUID,
    val name: String,
)