package com.pedrocomitto.poc.orderquery.consumer.createdorder.subscriber

import com.pedrocomitto.poc.orderquery.domain.event.createdorder.CreatedOrderEvent
import org.apache.kafka.clients.consumer.ConsumerRecord

interface CreatedOrderConsumerSubscriber {

    fun process(consumerRecord: ConsumerRecord<String, CreatedOrderEvent>)

}