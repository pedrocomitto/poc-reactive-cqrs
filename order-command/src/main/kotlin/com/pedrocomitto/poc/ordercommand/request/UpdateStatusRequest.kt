package com.pedrocomitto.poc.ordercommand.request

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus

data class UpdateStatusRequest(
    val status: OrderStatus
)