package com.pedrocomitto.poc.ordercommand.producer

import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.CreatedOrderEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CreatedOrderProducer(
    private val kafkaTemplate: KafkaTemplate<String, CreatedOrderEvent>
) {

    fun produce(createdOrderEvent: CreatedOrderEvent) {
        kafkaTemplate.send("created.order", createdOrderEvent.id.toString(), createdOrderEvent)
    }

}