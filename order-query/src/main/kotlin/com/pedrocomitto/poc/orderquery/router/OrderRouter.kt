package com.pedrocomitto.poc.orderquery.router

import com.pedrocomitto.poc.orderquery.handler.ChatBotOrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class OrderRouter {

    @Bean
    fun routes(handler: ChatBotOrderHandler) = coRouter {
        GET("/orders/{orderId}", queryParam("view") { p -> p == "chatbot" }, handler::findAllByOrderId)
    }

}