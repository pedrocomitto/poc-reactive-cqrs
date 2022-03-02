package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Address
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.AddressEvent
import com.pedrocomitto.poc.ordercommand.domain.request.AddressRequest

fun AddressRequest.toEntity() =
    Address(
        description = description,
        number = number,
        zipCode = zipCode
    )

fun Address.toEvent() =
    AddressEvent(
        description = description,
        number = number,
        zipCode = zipCode
    )