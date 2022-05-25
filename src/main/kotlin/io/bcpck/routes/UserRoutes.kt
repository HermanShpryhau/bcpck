package io.bcpck.routes

import io.ktor.server.routing.*

const val USERS_ROUTE = "/users"

fun Route.userRoutes() {
    allUsers()
    userById()
    createUser()
    usersBackpacks()
}

fun Route.allUsers() {
    get(USERS_ROUTE) {

    }
}

fun Route.userById() {
    get("$USERS_ROUTE/{id}") {

    }
}

fun Route.createUser() {
    post(USERS_ROUTE) {

    }
}

fun Route.usersBackpacks() {
    get("$USERS_ROUTE/{id}/backpacks") {

    }
}
