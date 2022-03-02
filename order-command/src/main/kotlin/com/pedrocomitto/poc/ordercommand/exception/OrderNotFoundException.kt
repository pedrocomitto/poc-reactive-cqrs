package com.pedrocomitto.poc.ordercommand.exception

import java.lang.RuntimeException

class OrderNotFoundException : RuntimeException("Order not found")