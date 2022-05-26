package io.bcpck.repository

import org.litote.kmongo.KMongo

object MongoContext {
    private val client = KMongo.createClient("mongodb+srv://bckpck:eEkGjf22p7ZpeJ3@cluster0.9wzh7.mongodb.net/?retryWrites=true&w=majority")
    val database = client.getDatabase("Cluster0")
}