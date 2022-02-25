package com.pedrocomitto.poc.orderquery.repository

import com.pedrocomitto.poc.orderquery.domain.view.ChatBotOrderView
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ChatBotOrderRepository : CoroutineCrudRepository<ChatBotOrderView, UUID>