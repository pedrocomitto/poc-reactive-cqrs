package com.pedrocomitto.poc.orderquery.domain.view

import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.orderquery.domain.enumeration.OrderType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.UUID

@Table("orders")
data class FullOrder(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val type: OrderType,
    var status: OrderStatus,
    val customer: Customer,
)

data class Customer(
    val id: UUID,
    val name: String
)