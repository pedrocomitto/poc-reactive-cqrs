package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.OrderItem
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.OrderItemEvent
import com.pedrocomitto.poc.ordercommand.domain.request.OrderItemRequest

fun OrderItemRequest.toEntity() =
    OrderItem(
        description = description,
        code = code
    )

fun OrderItem.toEvent() =
    OrderItemEvent(
        description = description,
        code = code
    )