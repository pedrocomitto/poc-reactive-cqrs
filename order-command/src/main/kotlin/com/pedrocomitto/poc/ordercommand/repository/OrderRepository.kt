package com.pedrocomitto.poc.ordercommand.repository

import com.pedrocomitto.poc.ordercommand.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<Order, UUID>