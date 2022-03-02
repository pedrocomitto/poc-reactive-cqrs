package com.pedrocomitto.poc.ordercommand.controller

import com.pedrocomitto.poc.ordercommand.domain.request.TrackingRequest
import com.pedrocomitto.poc.ordercommand.service.TrackingService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders/{orderId}/trackings")
class TrackingController(
    private val trackingService: TrackingService
) {

    @PostMapping
    fun create(@PathVariable orderId: Long, @RequestBody request: TrackingRequest) {
        trackingService.create(orderId, request)
    }

}