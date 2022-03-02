package com.pedrocomitto.poc.ordercommand.service

import com.pedrocomitto.poc.ordercommand.domain.enumeration.OrderStatus
import com.pedrocomitto.poc.ordercommand.domain.request.OrderRequest
import com.pedrocomitto.poc.ordercommand.mapper.toEntity
import com.pedrocomitto.poc.ordercommand.mapper.toEvent
import com.pedrocomitto.poc.ordercommand.producer.CreatedOrderProducer
import com.pedrocomitto.poc.ordercommand.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val createdOrderProducer: CreatedOrderProducer
) {

    fun create(request: OrderRequest) {
        orderRepository.save(request.toEntity(OrderStatus.PREPARING)).let {
            createdOrderProducer.produce(it.toEvent())
        }
    }

}