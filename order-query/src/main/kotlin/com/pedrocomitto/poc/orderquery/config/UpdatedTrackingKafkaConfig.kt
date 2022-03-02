package com.pedrocomitto.poc.orderquery.config

import com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter
import org.springframework.kafka.support.converter.JsonMessageConverter
import reactor.kafka.receiver.ReceiverOptions
import java.util.Collections


@Configuration
class UpdatedTrackingKafkaConfig {

    @Bean
    fun updatedTrackingReceiverOptions(
//        @Value(value = "\${FAKE_CONSUMER_DTO_TOPIC}") topic: String?,
        kafkaProperties: KafkaProperties
    ): ReceiverOptions<String, UpdatedTrackingEvent> {
        val properties = kafkaProperties.buildConsumerProperties()
        properties["spring.json.value.default.type"] = "com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent"
        
        val basicReceiverOptions: ReceiverOptions<String, UpdatedTrackingEvent> =
            ReceiverOptions.create(properties)
        return basicReceiverOptions.subscription(Collections.singletonList("updated.tracking"))
    }

    @Bean
    fun updatedTrackingConsumerTemplate(updatedTrackingReceiverOptions: ReceiverOptions<String, UpdatedTrackingEvent>): ReactiveKafkaConsumerTemplate<String, UpdatedTrackingEvent> {
        return ReactiveKafkaConsumerTemplate(updatedTrackingReceiverOptions)
    }

    @Bean
    fun jsonMessageConverter(): JsonMessageConverter {
        return ByteArrayJsonMessageConverter()
    }

}