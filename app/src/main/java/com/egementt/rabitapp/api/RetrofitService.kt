package com.egementt.rabitapp.api

import androidx.lifecycle.LiveData
import com.egementt.rabitapp.model.Rabbit
import com.egementt.rabitapp.util.BASE_URL
import retrofit2.http.GET

interface RetrofitService {

    @GET("/randomrabbit")
    suspend fun getRabbit():Rabbit
}