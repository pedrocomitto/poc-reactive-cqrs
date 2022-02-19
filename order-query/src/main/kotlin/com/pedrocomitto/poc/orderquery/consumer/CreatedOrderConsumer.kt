package com.pedrocomitto.poc.orderquery.consumer

import com.pedrocomitto.poc.orderquery.domain.event.OrderEvent
import com.pedrocomitto.poc.orderquery.mapper.toView
import com.pedrocomitto.poc.orderquery.repository.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.stereotype.Component

@Component
class CreatedOrderConsumer(
    private val reactiveKafkaConsumerTemplate: ReactiveKafkaConsumerTemplate<String, OrderEvent>,
    private val orderRepository: OrderRepository
) : CommandLineRunner{

    private val log = LoggerFactory.getLogger(javaClass)

    private fun consume() =
        reactiveKafkaConsumerTemplate.receiveAutoAck()
            .doOnNext { CoroutineScope(Dispatchers.IO).launch { orderRepository.save(it.value().toView()) } }
            .doFinally { log.info("consumi") }


    override fun run(vararg args: String?) {
        consume().subscribe()
    }
}