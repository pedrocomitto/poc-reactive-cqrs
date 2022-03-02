package com.pedrocomitto.poc.orderquery.repository

import com.pedrocomitto.poc.orderquery.domain.view.ChatBotOrderView
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ChatbotOrderRepository : CoroutineCrudRepository<ChatBotOrderView, UUID> {

    suspend fun findTop1ByOrderIdOrderByCreationDateDesc(orderId: Long): ChatBotOrderView?

    suspend fun findAllByOrderId(orderId: Long): Flow<ChatBotOrderView>

}