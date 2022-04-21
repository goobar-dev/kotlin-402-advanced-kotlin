package dev.goobar.plugins

import dev.goobar.JokeGenerator
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World")
        }

        authenticate("basic") {
            get("/joke") {
                call.principal<UserIdPrincipal>().onValidUser {
                    call.respond(JokeGenerator.getJoke())
                }
            }
        }
    }
}

