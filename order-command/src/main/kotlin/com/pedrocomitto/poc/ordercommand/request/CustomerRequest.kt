package com.pedrocomitto.poc.ordercommand.request

import java.util.UUID

data class CustomerRequest(
    val id: UUID,
    val name: String,
)