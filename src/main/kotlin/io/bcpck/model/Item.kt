package io.bcpck.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.litote.kmongo.Id
import org.litote.kmongo.newId

@Serializable
data class Item(
    @Contextual val _id: Id<Item> = newId(),
    val title: String,
    val description: String,
    val amount: Int,
    val backpackId: String
)
