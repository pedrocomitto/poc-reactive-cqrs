package com.pedrocomitto.poc.ordercommand.domain.event

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

data class CustomerEvent(
    val customerId: UUID,
    val name: String,
    val document: String
)