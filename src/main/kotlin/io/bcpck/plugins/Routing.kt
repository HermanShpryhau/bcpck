package io.bcpck.plugins

import io.bcpck.routes.backpackRoutes
import io.bcpck.routes.itemRoutes
import io.bcpck.routes.userRoutes
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        backpackRoutes()
        itemRoutes()
        userRoutes()
    }
}
