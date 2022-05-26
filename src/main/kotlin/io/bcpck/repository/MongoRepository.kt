package io.bcpck.repository

import com.mongodb.client.MongoCollection

interface MongoRepository<T> {
    val collection: MongoCollection<T>

    fun save(entity: T): T?

    fun findAll(): List<T> {
        return collection.find().toList()
    }

    fun findById(id: String?): T?

    fun delete(id: String?): Long
}