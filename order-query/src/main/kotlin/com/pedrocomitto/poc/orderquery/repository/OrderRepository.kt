package com.pedrocomitto.poc.orderquery.repository

import com.pedrocomitto.poc.orderquery.domain.view.FullOrder
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository : CoroutineCrudRepository<FullOrder, UUID>