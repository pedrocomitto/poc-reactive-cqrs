package com.pedrocomitto.poc.orderquery.controller

import com.pedrocomitto.poc.orderquery.handler.ChatBotOrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class OrderRouter {

    @Bean
    fun routes(handler: ChatBotOrderHandler) = coRouter {
        GET("/orders/{id}?view=chatbot", handler::find)
    }

}