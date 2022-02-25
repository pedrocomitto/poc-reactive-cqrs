package com.pedrocomitto.poc.orderquery.consumer

import com.pedrocomitto.poc.orderquery.domain.event.OrderEvent
import com.pedrocomitto.poc.orderquery.mapper.toChatBotOrderView
import com.pedrocomitto.poc.orderquery.repository.ChatBotOrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.stereotype.Component

@Configuration
class CreatedOrderConsumer(
    private val reactiveKafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, OrderEvent>,
    private val subscribers: List<CreatedOrderConsumerSubscriber>
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun consume() {
        val kafka = reactiveKafkaConsumerTemplate.receiveAutoAck()
            .publish()

        subscribers.forEach {
                subscriber -> kafka.subscribe { subscriber.process(it) }
        }

        kafka.connect()
    }

}

interface CreatedOrderConsumerSubscriber {

    fun process(consumerRecord: ConsumerRecord<String, OrderEvent>)

}

@Component
class ChatBotSubscriber(
    private val chatBotOrderRepository: ChatBotOrderRepository,
) : CreatedOrderConsumerSubscriber {

    override fun process(consumerRecord: ConsumerRecord<String, OrderEvent>) {
        run {
            CoroutineScope(Dispatchers.IO)
                .launch {
                    chatBotOrderRepository.save(consumerRecord.value().toChatBotOrderView(""))
                }
        }
    }

}
