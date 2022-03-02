package com.pedrocomitto.poc.orderquery.consumer.createdorder.subscriber

import com.pedrocomitto.poc.orderquery.consumer.ConsumerSubscriber
import com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent
import com.pedrocomitto.poc.orderquery.mapper.toChatbotOrderView
import com.pedrocomitto.poc.orderquery.repository.ChatbotOrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.stereotype.Component

@Component
class ChatbotOrderSubscriber(
    private val chatbotOrderRepository: ChatbotOrderRepository,
) : ConsumerSubscriber<CreatedOrderEvent> {

    override fun process(consumerRecord: ConsumerRecord<String, CreatedOrderEvent>) {
        run {
            CoroutineScope(Dispatchers.IO)
                .launch {
                    chatbotOrderRepository.save(consumerRecord.value().toChatbotOrderView())
                }
        }
    }

}