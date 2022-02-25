package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Customer
import com.pedrocomitto.poc.ordercommand.domain.event.CustomerEvent
import com.pedrocomitto.poc.ordercommand.request.CustomerRequest

fun CustomerRequest.toCustomer() =
    Customer(
        id = id,
        name = name,
    )

fun Customer.toEvent() =
    CustomerEvent(
        id = id,
        name = name,
    )