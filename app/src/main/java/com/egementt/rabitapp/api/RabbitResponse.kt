package com.egementt.rabitapp.api

import com.egementt.rabitapp.model.Rabbit

sealed class RabbitResponse(val data: Rabbit? = null, val message: String? = ""){
    object Loading : RabbitResponse()
    class Success(data: Rabbit) : RabbitResponse(data = data!!)
    class Error(message: String?) : RabbitResponse(message = message)
}