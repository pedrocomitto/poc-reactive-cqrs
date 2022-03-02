package com.pedrocomitto.poc.ordercommand.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "trackings")
data class Tracking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val code: String,
    val status: String,

    @Column(name = "order_id")
    val orderId: Long
)