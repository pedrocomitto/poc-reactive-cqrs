package com.pedrocomitto.poc.ordercommand.domain.entity

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID = UUID.randomUUID(),

    val status: OrderStatus,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "order_id")
    val items: List<OrderItem> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL])
    val customer: Customer,

    @OneToOne(cascade = [CascadeType.ALL])
    val address: Address,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", columnDefinition = "")
    val trackings: List<Tracking> = mutableListOf()
)