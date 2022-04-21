package dev.goobar.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*

fun Application.configureHeaders() {
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
}