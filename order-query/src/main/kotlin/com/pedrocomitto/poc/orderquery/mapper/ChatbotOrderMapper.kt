package com.pedrocomitto.poc.orderquery.mapper

import com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent
import com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent
import com.pedrocomitto.poc.orderquery.domain.view.ChatBotOrderView

fun CreatedOrderEvent.toChatbotOrderView() =
    ChatBotOrderView(
        orderId = id,
        status = status,
    )

fun UpdatedTrackingEvent.toChatbotOrderView(orderView: ChatBotOrderView) =
    ChatBotOrderView(
        orderId = orderId,
        status = orderView.status,
        trackingStatus = status,
    )
