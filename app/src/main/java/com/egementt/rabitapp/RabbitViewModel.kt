package com.egementt.rabitapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egementt.rabitapp.api.RabbitResponse
import com.egementt.rabitapp.model.Rabbit
import kotlinx.coroutines.launch
import java.lang.Exception


class RabbitViewModel(private val repository: RabbitRepository) : ViewModel() {

    private  val _rabbit = MutableLiveData<RabbitResponse>(RabbitResponse.Loading)
    val randomRabbit : LiveData<RabbitResponse> = _rabbit

    init {
        getRabbit()
    }


    fun getRabbit() {
        viewModelScope.launch {
            _rabbit.postValue(RabbitResponse.Loading)
            try {
                _rabbit.postValue(RabbitResponse.Success(data = repository.getRabbit()))
            }catch (e: Exception){
                Log.e("RabbitViewModel", "getRandomRabbit: $e")
                _rabbit.postValue(RabbitResponse.Error(message = e.message))
            }
        }
    }

}