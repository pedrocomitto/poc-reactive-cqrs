package com.pedrocomitto.poc.ordercommand.request

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderType
import java.util.UUID

data class OrderRequest(
    val customerId: UUID,
    val type: OrderType,
)
