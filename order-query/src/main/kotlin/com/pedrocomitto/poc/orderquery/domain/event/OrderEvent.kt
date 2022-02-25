package com.pedrocomitto.poc.orderquery.domain.event

import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderType
import java.util.UUID

data class OrderEvent(
    val id: UUID,
    val type: OrderType,
    var status: OrderStatus,
    val items: List<OrderItemEvent>,
    val customer: CustomerEvent,
    var payment: PaymentEvent? = null,
)
