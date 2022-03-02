package com.pedrocomitto.poc.ordercommand.producer

import com.pedrocomitto.poc.ordercommand.domain.event.updatedtracking.UpdatedTrackingEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UpdatedTrackingProducer(
    private val kafkaTemplate: KafkaTemplate<String, UpdatedTrackingEvent>
) {

    fun produce(updatedTrackingEvent: UpdatedTrackingEvent) {
        kafkaTemplate.send("updated.tracking", updatedTrackingEvent.orderId.toString(), updatedTrackingEvent)
        println("tracking enviado")
    }
}