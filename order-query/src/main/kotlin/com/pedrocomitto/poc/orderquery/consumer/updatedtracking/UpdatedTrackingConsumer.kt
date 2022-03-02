package com.pedrocomitto.poc.orderquery.consumer.updatedtracking

import com.pedrocomitto.poc.orderquery.consumer.updatedtracking.subscriber.UpdatedTrackingConsumerSubscriber
import com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.BytesDeserializer
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import javax.annotation.PostConstruct

@Configuration
class UpdatedTrackingConsumer(
    private val reactiveKafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, UpdatedTrackingEvent>,
    private val subscribers: List<UpdatedTrackingConsumerSubscriber>
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostConstruct
    fun consume() {
        val kafka = reactiveKafkaConsumerTemplate.receiveAutoAck()
            .subscribe { record ->
                subscribers.forEach { sub -> sub.process(record) }
            }
    }

}