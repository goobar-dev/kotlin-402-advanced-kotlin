package dev.goobar

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.goobar.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureStatusPages()
        configureAuthentication()
        configureHeaders()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
