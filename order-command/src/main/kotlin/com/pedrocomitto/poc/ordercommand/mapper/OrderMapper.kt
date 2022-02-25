package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Address
import com.pedrocomitto.poc.ordercommand.domain.entity.Customer
import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import com.pedrocomitto.poc.ordercommand.domain.entity.OrderItem
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.request.AddressRequest
import com.pedrocomitto.poc.ordercommand.domain.request.CustomerRequest
import com.pedrocomitto.poc.ordercommand.domain.request.OrderItemRequest
import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest
import java.util.UUID


fun OrderRequest.toEntity(status: OrderStatus) =
    Order(
//        items = items.map { it.toEntity() },
        customer = customer.toEntity(),
        address = address.toEntity(),
        status = status,
    )

fun OrderItemRequest.toEntity() =
    OrderItem(
        description = description,
        code = code
    )

fun CustomerRequest.toEntity() =
    Customer(
        customerId = customerId,
        name = name,
        document = document
    )

fun AddressRequest.toEntity() =
    Address(
        description = description,
        number = number,
        zipCode = zipCode
    )