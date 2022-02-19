package com.pedrocomitto.poc.orderquery.config

import com.pedrocomitto.poc.orderquery.domain.event.OrderEvent
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import reactor.kafka.receiver.ReceiverOptions
import java.util.Collections

@Configuration
class KafkaConfig {

    @Bean
    fun kafkaReceiverOptions(
//        @Value(value = "\${FAKE_CONSUMER_DTO_TOPIC}") topic: String?,
        kafkaProperties: KafkaProperties
    ): ReceiverOptions<String, OrderEvent> {
        val basicReceiverOptions: ReceiverOptions<String, OrderEvent> =
            ReceiverOptions.create(kafkaProperties.buildConsumerProperties())
        return basicReceiverOptions.subscription(Collections.singletonList("created.order"))
    }

    @Bean
    fun reactiveKafkaConsumerTemplate(kafkaReceiverOptions: ReceiverOptions<String, OrderEvent>): ReactiveKafkaConsumerTemplate<String, OrderEvent> {
        return ReactiveKafkaConsumerTemplate(kafkaReceiverOptions)
    }

}