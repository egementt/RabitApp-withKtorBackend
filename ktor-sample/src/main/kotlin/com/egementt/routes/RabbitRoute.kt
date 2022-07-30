package com.egementt.routes

import com.egementt.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


private const val BASE_URL = "http://localhost:8080"
//android emulator = 192.168.2.107:8080

private val rabbits = listOf(
    Rabbit("Carl", "A cute black rabbit", "https://petkeen.com/wp-content/uploads/2020/04/cute-black-rabbit.jpg"),
    Rabbit("Emma", "A cute white rabbit", "https://thumbs.dreamstime.com/b/baby-white-rabbit-grass-little-39774765.jpg"),
    Rabbit("Florian", "A cute brown rabbit", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Oryctolagus_cuniculus_Rcdo.jpg/484px-Oryctolagus_cuniculus_Rcdo.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "https://i.pinimg.com/736x/8a/9a/af/8a9aaf29052a2a70cb42ee9ff87ca190.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "https://media.4-paws.org/6/4/0/1/6401d1c6e76fb0838ffcf835dd387b6bba662fbd/Kaninchen%20im%20Freigehege%20%282%29-4440x3072-1920x1328.jpg"),

    )

fun Route.allRabbits(){
    get("/rabbit"){
        call.respond(
            HttpStatusCode.OK,
            rabbits.toString()
        )
    }
}

fun Route.randomRabbit(){
    get("/randomrabbit"){
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}