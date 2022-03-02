package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Address
import com.pedrocomitto.poc.ordercommand.domain.entity.Customer
import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import com.pedrocomitto.poc.ordercommand.domain.entity.OrderItem
import com.pedrocomitto.poc.ordercommand.domain.entity.Tracking
import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.AddressEvent
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.CustomerEvent
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.CreatedOrderEvent
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.OrderItemEvent
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.TrackingEvent
import com.pedrocomitto.poc.ordercommand.domain.request.AddressRequest
import com.pedrocomitto.poc.ordercommand.domain.request.CustomerRequest
import com.pedrocomitto.poc.ordercommand.domain.request.OrderItemRequest
import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest


fun OrderRequest.toEntity(status: OrderStatus) =
    Order(
        items = items.map { it.toEntity() },
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

fun Order.toEvent() =
    CreatedOrderEvent(
        id = id,
        status = status,
        items = items.map { it.toEvent() },
        customer = customer.toEvent(),
        address = address.toEvent(),
        trackings = trackings.map { it.toEvent() }
    )

fun OrderItem.toEvent() =
    OrderItemEvent(
        description = description,
        code = code
    )

fun Customer.toEvent() =
    CustomerEvent(
        customerId = customerId,
        name = name,
        document = document
    )

fun Address.toEvent() =
    AddressEvent(
        description = description,
        number = number,
        zipCode = zipCode
    )

fun Tracking.toEvent() =
    TrackingEvent(
        code = code,
        status = status
    )