package io.bcpck.routes

import io.bcpck.model.Backpack
import io.bcpck.model.Item
import io.bcpck.repository.BackpackRepository
import io.bcpck.repository.ItemRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.bson.types.ObjectId
import org.litote.kmongo.eq
import org.litote.kmongo.findOneById
import org.litote.kmongo.id.toId
import org.litote.kmongo.save

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
        call.respond(BackpackRepository.findAll())
    }
}

fun Route.backpackById() {
    get("$BACKPACKS_ROUTE/{id}") {
        val id = call.parameters["id"]
        if (id == null) call.respond(HttpStatusCode.BadRequest)

        call.respond(BackpackRepository.findById(id) ?: HttpStatusCode.NotFound)
    }
}

fun Route.createBackpack() {
    post(BACKPACKS_ROUTE) {
        val backpack = call.receive<Backpack>()
        call.respond(BackpackRepository.save(backpack) ?: HttpStatusCode.NotFound)
    }
}

fun Route.deleteBackpack() {
    delete("$BACKPACKS_ROUTE/{id}") {
        val id = call.parameters["id"]
        if (id == null) call.respond(HttpStatusCode.BadRequest)

        val deleteCount = BackpackRepository.delete(id)
        call.respond(
            if (deleteCount > 0L) HttpStatusCode.OK else HttpStatusCode.NotFound
        )
    }
}

fun Route.itemsInBackpack() {
    get("$BACKPACKS_ROUTE/{id}/items") {
        val id = call.parameters["id"]
        val backpack = BackpackRepository.findById(id)
        if (backpack == null) call.respond(HttpStatusCode.NotFound)
        call.respond(ItemRepository.findBYBackpackId(id).toList())
    }
}
