package com.pedrocomitto.poc.ordercommand.router

import com.pedrocomitto.poc.ordercommand.handler.OrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class OrderRouter {

    @Bean
    fun routes(handler: OrderHandler) = coRouter {
        GET("/orders", handler::findAll)
        POST("/orders", handler::create)
        PATCH("/orders/{id}", handler::updateStatus)
    }

}