package dev.goobar.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*

object AuthenticationException: Throwable()

suspend fun UserIdPrincipal?.onValidUser(action: suspend UserIdPrincipal.() -> Unit) {
    if (this != null) {
        action(this)
    } else {
        throw AuthenticationException
    }
}

fun Application.configureAuthentication() {
    authentication {
        basic(name = "basic") {
            realm = "Ktor Server"
            validate { credentials ->
                if (credentials.name == credentials.password) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}