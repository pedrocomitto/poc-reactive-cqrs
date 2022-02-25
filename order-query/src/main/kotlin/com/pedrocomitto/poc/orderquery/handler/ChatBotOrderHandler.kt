package com.pedrocomitto.poc.orderquery.handler

import com.pedrocomitto.poc.orderquery.repository.ChatBotOrderRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class ChatBotOrderHandler(
    private val chatBotOrderRepository: ChatBotOrderRepository
) {

    suspend fun find(request: ServerRequest) =
        ServerResponse.ok()
            .bodyAndAwait(
                chatBotOrderRepository.findAll()
            )

}