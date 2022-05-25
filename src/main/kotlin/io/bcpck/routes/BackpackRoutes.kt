package io.bcpck.routes

import io.ktor.server.routing.*

const val BACKPACKS_ROUTE = "/backpacks"

fun Route.backpackRoutes() {
    allBackpacks()
    backpackById()
    createBackpack()
    deleteBackpack()
    itemsInBackpack()
}

fun Route.allBackpacks() {
    get(BACKPACKS_ROUTE) {

    }
}

fun Route.backpackById() {
    get("$BACKPACKS_ROUTE/{id}") {

    }
}

fun Route.createBackpack() {
    post(BACKPACKS_ROUTE) {

    }
}

fun Route.deleteBackpack() {
    delete("$BACKPACKS_ROUTE/{id}") {

    }
}

fun Route.itemsInBackpack() {
    get("$BACKPACKS_ROUTE/{id}/items") {

    }
}
