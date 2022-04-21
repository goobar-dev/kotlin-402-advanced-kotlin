package dev.goobar.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.p

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondHtml {
                body {
                    h1 { +"We couldn't find that page" }
                    p { +call.request.path() }
                }
            }
        }
        status(HttpStatusCode.Forbidden) { call, status ->
            call.respondText("Whoa, whoa, whoa... what are you trying to do?")
        }
    }
}
