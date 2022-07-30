package com.egementt.plugins

import com.egementt.routes.allRabbits
import com.egementt.routes.randomRabbit
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {


    routing {
        randomRabbit()
        val rabbit = allRabbits()
        get("/") {
            call.respond(rabbit)
        }
        // Static plugin. Try to access `/static/index.html`
        static() {
            resources("static")
        }
    }
}
