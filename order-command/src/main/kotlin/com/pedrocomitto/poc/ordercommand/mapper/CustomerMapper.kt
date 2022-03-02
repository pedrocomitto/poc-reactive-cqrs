package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Customer
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.CustomerEvent
import com.pedrocomitto.poc.ordercommand.domain.request.CustomerRequest

fun CustomerRequest.toEntity() =
    Customer(
        customerId = customerId,
        name = name,
        document = document
    )

fun Customer.toEvent() =
    CustomerEvent(
        customerId = customerId,
        name = name,
        document = document
    )