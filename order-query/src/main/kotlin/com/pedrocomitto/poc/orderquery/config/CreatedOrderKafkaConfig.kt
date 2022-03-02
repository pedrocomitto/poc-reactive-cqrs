package com.pedrocomitto.poc.orderquery.config

import com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.converter.BytesJsonMessageConverter
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.StringOrBytesSerializer
import reactor.kafka.receiver.ReceiverOptions
import java.util.Collections

@Configuration
class CreatedOrderKafkaConfig {

    @Bean
    fun createdOrderReceiverOptions(
//        @Value(value = "\${FAKE_CONSUMER_DTO_TOPIC}") topic: String?,
        kafkaProperties: KafkaProperties
    ): ReceiverOptions<String, CreatedOrderEvent> {
        val properties = kafkaProperties.buildConsumerProperties()
        properties["spring.json.value.default.type"] = "com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent"

        val basicReceiverOptions =
            ReceiverOptions.create<String, CreatedOrderEvent>(properties)
        return basicReceiverOptions.subscription(Collections.singletonList("created.order"))
    }

    @Bean
    fun createdOrderConsumerTemplate(createdOrderReceiverOptions: ReceiverOptions<String, CreatedOrderEvent>): ReactiveKafkaConsumerTemplate<String, CreatedOrderEvent> {
        return ReactiveKafkaConsumerTemplate(createdOrderReceiverOptions)
    }

}