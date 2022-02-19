package com.pedrocomitto.poc.orderquery.mapper

import com.pedrocomitto.poc.orderquery.domain.event.OrderEvent
import com.pedrocomitto.poc.orderquery.domain.view.FullOrder

fun OrderEvent.toView() =
    FullOrder(
        id = id,
        type = type,
        status = status,
        customerId = customerId
    )