package com.pedrocomitto.poc.orderquery.domain.event

import java.util.UUID

data class CustomerEvent(
    val id: UUID,
    val name: String,
)