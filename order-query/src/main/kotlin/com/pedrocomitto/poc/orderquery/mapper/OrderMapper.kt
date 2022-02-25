package com.pedrocomitto.poc.orderquery.mapper

import com.pedrocomitto.poc.orderquery.domain.event.OrderEvent
import com.pedrocomitto.poc.orderquery.domain.view.ChatBotOrderView

fun OrderEvent.toChatBotOrderView(trackingStatus: String) =
    ChatBotOrderView(
        id = id,
        type = type,
        status = status,
        trackingStatus = trackingStatus
    )