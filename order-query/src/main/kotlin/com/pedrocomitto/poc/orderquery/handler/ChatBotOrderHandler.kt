package com.pedrocomitto.poc.orderquery.handler

import com.pedrocomitto.poc.orderquery.repository.ChatbotOrderRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class ChatBotOrderHandler(
    private val chatbotOrderRepository: ChatbotOrderRepository
) {

    suspend fun findAllByOrderId(request: ServerRequest) =
        ServerResponse.ok()
            .bodyAndAwait(
                chatbotOrderRepository.findAllByOrderId(request.pathVariable("orderId").toLong())
            )

}