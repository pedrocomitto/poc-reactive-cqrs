package com.pedrocomitto.poc.ordercommand.domain.event

import java.util.UUID

data class PaymentEvent(
    val id: UUID
)