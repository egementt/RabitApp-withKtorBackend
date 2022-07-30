package com.egementt.rabitapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.egementt.rabitapp.api.RabbitResponse
import com.egementt.rabitapp.databinding.ActivityMainBinding
import com.egementt.rabitapp.util.beInvisible
import com.egementt.rabitapp.util.beVisible
import okhttp3.HttpUrl.Companion.toHttpUrl

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var repository: RabbitRepository = RabbitRepository()
    private var viewModel: RabbitViewModel = RabbitViewModel(repository)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            buttonClick()
        }

        viewModel.randomRabbit.observeForever {

            when (it) {
                RabbitResponse.Loading -> {
                    binding.progressBar.beVisible()
                }
                is RabbitResponse.Success -> {
                    binding.apply {
                        progressBar.beInvisible()
                        tvName.text = it.data!!.name
                        tvDesc.text = it.data.description


                    }
                    binding.ivRabbit.load(it.data!!.imageUrl)


                }
                is RabbitResponse.Error -> {
                    binding.progressBar.beInvisible()


                }
            }

        }

    }


    private fun buttonClick() {
        binding.button.setOnClickListener {
            viewModel.getRabbit()

        }
    }
}


