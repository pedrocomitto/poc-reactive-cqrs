package com.pedrocomitto.poc.ordercommand.mapper

import com.pedrocomitto.poc.ordercommand.domain.entity.Tracking
import com.pedrocomitto.poc.ordercommand.domain.event.createdorder.TrackingEvent
import com.pedrocomitto.poc.ordercommand.domain.event.updatedtracking.UpdatedTrackingEvent
import com.pedrocomitto.poc.ordercommand.domain.request.TrackingRequest

fun TrackingRequest.toTracking(orderId: Long) =
    Tracking(
        status = status,
        code = statusCode,
        orderId = orderId,
    )

fun Tracking.toUpdatedTrackingEvent() =
    UpdatedTrackingEvent(
        orderId = orderId,
        status = status,
        code = code,
    )

fun Tracking.toEvent() =
    TrackingEvent(
        code = code,
        status = status
    )
