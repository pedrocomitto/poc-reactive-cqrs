package com.pedrocomitto.poc.ordercommand.domain.document

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document("orders")
class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    val type: OrderType,
    var status: OrderStatus,
    val items: List<OrderItem>,
    val customer: Customer,
    var payment: Payment? = null,
)

