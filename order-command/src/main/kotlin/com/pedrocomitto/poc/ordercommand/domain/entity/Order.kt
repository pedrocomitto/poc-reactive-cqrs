package com.pedrocomitto.poc.ordercommand.domain.entity

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import org.hibernate.annotations.GeneratorType
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.hibernate.id.UUIDGenerationStrategy
import org.hibernate.id.UUIDGenerator
import org.hibernate.type.UUIDBinaryType
import org.hibernate.type.UUIDCharType
import org.springframework.data.domain.Persistable
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Column
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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "id", updatable = false, nullable = false)
    var id: UUID = UUID.randomUUID(),

    val status: OrderStatus,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "order_id", columnDefinition = "UUID")
    val items: List<OrderItem> = mutableListOf(),

    @OneToOne(cascade = [CascadeType.ALL])
    val customer: Customer,

    @OneToOne(cascade = [CascadeType.ALL])
    val address: Address,

//    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
//    @JoinColumn(name = "order_id", columnDefinition = "UUID")
//    val trackings: List<Tracking> = mutableListOf()
)
