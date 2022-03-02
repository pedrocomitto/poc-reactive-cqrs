package com.pedrocomitto.poc.orderquery.consumer.createdorder

import com.pedrocomitto.poc.orderquery.consumer.createdorder.subscriber.CreatedOrderConsumerSubscriber
import com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import javax.annotation.PostConstruct

@Configuration
class CreatedOrderConsumer(
    private val reactiveKafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, CreatedOrderEvent>,
    private val subscribers: List<CreatedOrderConsumerSubscriber>
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
