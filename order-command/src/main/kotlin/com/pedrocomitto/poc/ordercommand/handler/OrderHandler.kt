package com.pedrocomitto.poc.ordercommand.handler

import com.pedrocomitto.poc.ordercommand.mapper.toEntity
import com.pedrocomitto.poc.ordercommand.mapper.toEvent
import com.pedrocomitto.poc.ordercommand.producer.CreatedOrderProducer
import com.pedrocomitto.poc.ordercommand.repository.OrderRepository
import com.pedrocomitto.poc.ordercommand.request.OrderRequest
import com.pedrocomitto.poc.ordercommand.request.UpdateStatusRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import java.util.UUID

@Component
class OrderHandler(
    private val repository: OrderRepository,
    private val createdOrderProducer: CreatedOrderProducer
) {

    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun findAll(request: ServerRequest) =
        ServerResponse.ok()
            .bodyAndAwait(
                repository.findAll()
            )

    @Transactional
    suspend fun create(request: ServerRequest) =
        repository.save(
            request.awaitBody(OrderRequest::class).toEntity()
        )
        .also { createdOrderProducer.produce(it.toEvent()) }
        .let {
            ServerResponse.created(request.uri()).buildAndAwait()
        }

    @Transactional
    suspend fun updateStatus(request: ServerRequest): ServerResponse {
        repository.findById(UUID.fromString(request.pathVariable("id")))
            ?.let {
                it.status = request.awaitBody(UpdateStatusRequest::class).status
                repository.save(it)
            } ?: return ServerResponse.notFound().buildAndAwait()

        return ServerResponse.noContent().buildAndAwait()
    }

}