package io.bcpck.repository

import com.mongodb.client.MongoCollection
import io.bcpck.model.Backpack
import org.bson.types.ObjectId
import org.litote.kmongo.deleteOneById
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.litote.kmongo.save

object BackpackRepository: MongoRepository<Backpack> {
    override val collection: MongoCollection<Backpack> = MongoContext.database.getCollection()

    override fun save(entity: Backpack): Backpack? {
        collection.save(entity)
        return collection.findOneById(ObjectId(entity._id.toString()))
    }

    override fun findById(id: String?): Backpack? {
        return collection.findOneById(ObjectId(id))
    }

    override fun delete(id: String?): Long {
        return collection.deleteOneById(ObjectId(id)).deletedCount
    }
}