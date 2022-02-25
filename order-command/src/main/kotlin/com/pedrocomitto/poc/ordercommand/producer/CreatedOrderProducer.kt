package com.pedrocomitto.poc.ordercommand.producer

import com.pedrocomitto.poc.ordercommand.domain.event.OrderEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CreatedOrderProducer(
    private val kafkaTemplate: KafkaTemplate<String, OrderEvent>
) {

    fun produce(orderEvent: OrderEvent) {
        kafkaTemplate.send("created.order", "key", orderEvent)
    }

}