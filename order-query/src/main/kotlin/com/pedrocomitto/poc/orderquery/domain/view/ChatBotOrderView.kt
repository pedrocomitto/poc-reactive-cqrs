package com.pedrocomitto.poc.orderquery.domain.view

import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderStatus
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document("chatbot_order_view")
data class ChatBotOrderView(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Indexed
    val orderId: Long,
    var status: OrderStatus,
    val trackingStatus: String? = null,
    var creationDate: LocalDateTime? = LocalDateTime.now()
)
