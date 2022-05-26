package io.bcpck

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.bcpck.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureRouting()
        configureHTTP()
        configureSerialization()
    }.start(wait = true)
}
