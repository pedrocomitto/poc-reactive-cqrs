package com.pedrocomitto.poc.ordercommand.domain.request

data class OrderRequest(
    val items: List<OrderItemRequest>,
    val customer: CustomerRequest,
    val address: AddressRequest,
)