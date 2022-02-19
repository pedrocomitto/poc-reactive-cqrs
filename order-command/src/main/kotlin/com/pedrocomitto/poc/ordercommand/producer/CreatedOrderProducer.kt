package com.pedrocomitto.poc.ordercommand.producer

import com.pedrocomitto.poc.ordercommand.domain.event.OrderEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class CreatedOrderProducer(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, OrderEvent>
) {

    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun produce(event: OrderEvent) =
        reactiveKafkaProducerTemplate.send("created.order", event.id.toString(), event)
            .doOnSuccess { log.info("M=produce, I=created-order event sent, id=${event.id}") }
            .subscribe()

}
