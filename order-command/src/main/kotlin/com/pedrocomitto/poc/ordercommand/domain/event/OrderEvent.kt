package com.pedrocomitto.poc.ordercommand.domain.event

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import java.util.UUID

data class OrderEvent(
    val uuid: UUID,
    val status: OrderStatus,
    val items: List<OrderItemEvent>,
    val customer: CustomerEvent,
    val address: AddressEvent,
    val trackings: List<TrackingEvent>
)
