package io.bcpck.routes

import io.bcpck.model.Item
import io.bcpck.repository.ItemRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
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
        val id = call.parameters["id"]
        call.respond(ItemRepository.findById(id) ?: HttpStatusCode.NotFound)
    }
}

fun Route.createItem() {
    post(ITEMS_ROUTE) {
        val item = call.receive<Item>()
        call.respond(ItemRepository.save(item) ?: HttpStatusCode.NotFound)
    }
}

fun Route.updateItem() {
    put(ITEMS_ROUTE) {
        val item = call.receive<Item>()
        call.respond(ItemRepository.save(item) ?: HttpStatusCode.NotFound)
    }
}

fun Route.deleteItem() {
    delete("$ITEMS_ROUTE/{id}") {
        val id = call.parameters["id"]
        val deleteCount = ItemRepository.delete(id)
        call.respond(
            if (deleteCount > 0L) HttpStatusCode.OK else HttpStatusCode.NotFound
        )
    }
}