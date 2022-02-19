package com.pedrocomitto.poc.ordercommand.domain.event

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderType
import java.util.UUID

data class OrderEvent(
    val id: UUID,
    val type: OrderType,
    val status: OrderStatus,
    val customerId: UUID,
)
