package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.CreatedOrderEvent
import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest


fun OrderRequest.toEntity(status: OrderStatus) =
    Order(
        items = items.map { it.toEntity() },
        customer = customer.toEntity(),
        address = address.toEntity(),
        status = status,
    )



fun Order.toEvent() =
    CreatedOrderEvent(
        id = id,
        status = status,
        items = items.map { it.toEvent() },
        customer = customer.toEvent(),
        address = address.toEvent(),
        trackings = trackings.map { it.toEvent() }
    )





