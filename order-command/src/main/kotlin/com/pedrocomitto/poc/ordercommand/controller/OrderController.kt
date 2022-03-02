package com.pedrocomitto.poc.ordercommand.controller

import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest
import com.pedrocomitto.poc.ordercommand.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: OrderRequest) {
        orderService.create(request)
    }

}