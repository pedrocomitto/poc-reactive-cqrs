package com.pedrocomitto.poc.ordercommand.config

import com.pedrocomitto.poc.ordercommand.domain.event.OrderEvent
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions


@Configuration
class KafkaConfig {

    @Bean
    fun reactiveKafkaProducerTemplate(
        properties: KafkaProperties
    ): ReactiveKafkaProducerTemplate<String, OrderEvent> {
        val props = properties.buildProducerProperties()
        return ReactiveKafkaProducerTemplate(
            SenderOptions.create(
                props
            )
        )
    }

}