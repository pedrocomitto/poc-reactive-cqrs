package com.pedrocomitto.poc.orderquery.domain.event.createdorder

import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderStatus

data class CreatedOrderEvent(
    val id: Long,
    val status: OrderStatus,
    val items: List<OrderItemEvent>,
    val customer: CustomerEvent,
    val address: AddressEvent,
    val trackings: List<TrackingEvent>
)
