package com.egementt.rabitapp

import com.egementt.rabitapp.api.BaseRetrofit
import com.egementt.rabitapp.api.RetrofitService
import com.egementt.rabitapp.model.Rabbit

class RabbitRepository () {

    private var retrofitApi : RetrofitService = BaseRetrofit.api

    suspend fun getRabbit() : Rabbit{
        return retrofitApi.getRabbit()
    }

}