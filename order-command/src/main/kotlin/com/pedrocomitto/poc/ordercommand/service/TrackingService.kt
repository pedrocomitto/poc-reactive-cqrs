package com.pedrocomitto.poc.ordercommand.service

import com.pedrocomitto.poc.ordercommand.domain.request.TrackingRequest
import com.pedrocomitto.poc.ordercommand.exception.OrderNotFoundException
import com.pedrocomitto.poc.ordercommand.mapper.toTracking
import com.pedrocomitto.poc.ordercommand.mapper.toUpdatedTrackingEvent
import com.pedrocomitto.poc.ordercommand.producer.UpdatedTrackingProducer
import com.pedrocomitto.poc.ordercommand.repository.OrderRepository
import com.pedrocomitto.poc.ordercommand.repository.TrackingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TrackingService(
    private val orderRepository: OrderRepository,
    private val trackingRepository: TrackingRepository,
    private val updatedTrackingProducer: UpdatedTrackingProducer
) {

    @Transactional
    fun create(orderId: Long, trackingRequest: TrackingRequest) {
        if (!orderRepository.existsById(orderId)) {
            throw OrderNotFoundException()
        }

        trackingRepository.save(trackingRequest.toTracking(orderId))
            .let { updatedTrackingProducer.produce(it.toUpdatedTrackingEvent()) }
    }
}