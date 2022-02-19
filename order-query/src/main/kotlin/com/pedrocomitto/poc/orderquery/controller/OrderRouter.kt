package com.pedrocomitto.poc.orderquery.controller

import com.pedrocomitto.poc.orderquery.handler.OrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class OrderRouter {

    @Bean
    fun routes(handler: OrderHandler) = coRouter {
        GET("/orders", handler::findAll)
    }

}