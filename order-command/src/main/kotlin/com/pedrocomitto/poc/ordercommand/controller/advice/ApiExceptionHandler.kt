package com.pedrocomitto.poc.ordercommand.controller.advice

import com.pedrocomitto.poc.ordercommand.exception.OrderNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(OrderNotFoundException::class)
    fun handleAssetNotFoundException(exception: Exception) =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
}