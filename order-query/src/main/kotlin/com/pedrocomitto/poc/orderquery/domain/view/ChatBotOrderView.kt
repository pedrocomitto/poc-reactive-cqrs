package com.pedrocomitto.poc.orderquery.domain.view

import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("chatbot_order_view")
data class ChatBotOrderView(
    @Id
    val id: UUID = UUID.randomUUID(),
    val type: OrderType,
    var status: OrderStatus,
    val trackingStatus: String,
)
