package com.pedrocomitto.poc.orderquery.consumer.updatedtracking.subscriber

import com.pedrocomitto.poc.orderquery.domain.event.updatedtracking.UpdatedTrackingEvent
import org.apache.kafka.clients.consumer.ConsumerRecord

interface UpdatedTrackingConsumerSubscriber {

    fun process(consumerRecord: ConsumerRecord<String, UpdatedTrackingEvent>)

}