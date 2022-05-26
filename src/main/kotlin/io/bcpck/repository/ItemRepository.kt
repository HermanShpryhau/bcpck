package io.bcpck.repository

import com.mongodb.client.MongoCollection
import io.bcpck.model.Item
import org.bson.types.ObjectId
import org.litote.kmongo.*

object ItemRepository: MongoRepository<Item> {
    override val collection: MongoCollection<Item> = MongoContext.database.getCollection()

    override fun save(entity: Item): Item? {
        collection.save(entity)
        return collection.findOneById(ObjectId(entity._id.toString()))
    }

    override fun findById(id: String?): Item? {
        return collection.findOneById(ObjectId(id))
    }

    fun findBYBackpackId(id: String?): List<Item> {
        return collection.find(Item::backpackId eq id).toList()
    }

    override fun delete(id: String?): Long {
        return collection.deleteOneById(ObjectId(id)).deletedCount
    }
}