package com.pedrocomitto.poc.ordercommand.domain.entity

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderType
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import java.util.UUID

@Table("ORDERS")
class Order(
    @Id
    val id: UUID = UUID.randomUUID(),
    val type: OrderType,
    var status: OrderStatus,
    val customerId: UUID,
    @Version
    var version: Long = 0
)

