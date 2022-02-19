package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.event.OrderEvent
import com.pedrocomitto.poc.ordercommand.request.OrderRequest

fun OrderRequest.toEntity() =
    Order(
        type = type,
        status = OrderStatus.PREPARING,
        customerId = customerId,
    )

fun Order.toEvent() =
    OrderEvent(
        id = id,
        type = type,
        status = status,
        customerId = customerId,
    )