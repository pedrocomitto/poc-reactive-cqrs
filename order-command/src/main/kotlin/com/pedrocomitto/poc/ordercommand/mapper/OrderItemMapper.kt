package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.document.OrderItem
import com.pedrocomitto.poc.ordercommand.domain.event.OrderItemEvent
import com.pedrocomitto.poc.ordercommand.request.OrderItemRequest

fun OrderItemRequest.toItem() =
    OrderItem(
        id = id,
        description = description,
        quantity = quantity,
    )

fun OrderItem.toEvent() =
    OrderItemEvent(
        id = id,
        description = description,
        quantity = quantity,
    )