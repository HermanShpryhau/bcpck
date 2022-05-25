package io.bcpck.routes

import io.ktor.server.routing.*

const val ITEMS_ROUTE = "/items"

fun Route.itemRoutes() {
    itemById()
    createItem()
    updateItem()
    deleteItem()
}

fun Route.itemById() {
    get("$ITEMS_ROUTE/{id}") {

    }
}

fun Route.createItem() {
    post(ITEMS_ROUTE) {

    }
}

fun Route.updateItem() {
    put (ITEMS_ROUTE) {

    }
}

fun Route.deleteItem() {
    delete("$ITEMS_ROUTE/{id}") {

    }
}