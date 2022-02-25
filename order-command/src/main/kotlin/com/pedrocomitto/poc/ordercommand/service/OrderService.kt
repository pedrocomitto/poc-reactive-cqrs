package com.pedrocomitto.poc.ordercommand.service

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest
import com.pedrocomitto.poc.ordercommand.mapper.toEntity
import com.pedrocomitto.poc.ordercommand.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun create(request: OrderRequest) {
        orderRepository.save(request.toEntity(OrderStatus.PREPARING))
    }

}