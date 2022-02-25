package com.pedrocomitto.poc.ordercommand.request

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderType

data class OrderRequest(
    val customer: CustomerRequest,
    val type: OrderType,
    val items: List<OrderItemRequest>,
)
