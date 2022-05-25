package io.bcpck.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.litote.kmongo.Id
import org.litote.kmongo.newId

@Serializable
data class User(
    @Contextual val _id: Id<User> = newId(),
    val username: String,
    val password: String)
