package com.pedrocomitto.poc.orderquery.handler

import com.pedrocomitto.poc.orderquery.repository.OrderRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class OrderHandler(
    private val orderRepository: OrderRepository
) {

    suspend fun findAll(request: ServerRequest) =
        ServerResponse.ok()
            .bodyAndAwait(
                orderRepository.findAll()
            )

}