package com.pedrocomitto.poc.ordercommand.repository

import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository : CoroutineCrudRepository<Order, UUID>