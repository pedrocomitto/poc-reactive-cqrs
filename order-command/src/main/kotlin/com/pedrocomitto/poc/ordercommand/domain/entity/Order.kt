package com.pedrocomitto.poc.ordercommand.domain.entity

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
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
    @Column(name = "id", updatable = false, nullable = false)
    var id: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: OrderStatus,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "order_id")
    val items: List<OrderItem> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL])
    val customer: Customer,

    @OneToOne(cascade = [CascadeType.ALL])
    val address: Address,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "order_id")
    val trackings: MutableList<Tracking> = mutableListOf()
)
