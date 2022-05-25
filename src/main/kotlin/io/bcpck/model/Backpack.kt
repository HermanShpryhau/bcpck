package io.bcpck.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.litote.kmongo.Id
import org.litote.kmongo.newId

@Serializable
data class Backpack(
    @Contextual val _id: Id<Backpack> = newId(),
    val name: String,
    val userId: String)
