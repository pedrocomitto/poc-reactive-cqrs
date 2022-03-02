package com.pedrocomitto.poc.orderquery.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord

interface ConsumerSubscriber<T> {

    fun process(consumerRecord: ConsumerRecord<String, T>)
}