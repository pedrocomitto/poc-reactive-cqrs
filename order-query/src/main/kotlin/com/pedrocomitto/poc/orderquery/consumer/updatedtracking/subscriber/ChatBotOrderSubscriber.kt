package com.pedrocomitto.poc.orderquery.consumer.updatedtracking.subscriber

import com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent
import com.pedrocomitto.poc.orderquery.mapper.toChatbotOrderView
import com.pedrocomitto.poc.orderquery.repository.ChatbotOrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class ChatBotOrderSubscriber(
    private val chatbotOrderRepository: ChatbotOrderRepository
) : UpdatedTrackingConsumerSubscriber {

    override fun process(consumerRecord: ConsumerRecord<String, UpdatedTrackingEvent>) {
        run {
            CoroutineScope(Dispatchers.IO)
                .launch {
                    val updatedTrackingEvent = consumerRecord.value()

                    val lastChatbotOrderView = chatbotOrderRepository.findTop1ByOrderIdOrderByCreationDateDesc(updatedTrackingEvent.orderId) ?: throw RuntimeException()

                    chatbotOrderRepository.save(updatedTrackingEvent.toChatbotOrderView(lastChatbotOrderView))
                }
        }
    }

}
