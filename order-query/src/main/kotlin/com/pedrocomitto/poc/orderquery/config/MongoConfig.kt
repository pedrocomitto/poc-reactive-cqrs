package com.pedrocomitto.poc.orderquery.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import com.pedrocomitto.poc.orderquery.repository.ChatBotOrderRepository
import org.bson.UuidRepresentation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories


@Configuration
@EnableReactiveMongoRepositories(
    basePackageClasses = [ChatBotOrderRepository::class]
)
class MongoConfig : AbstractReactiveMongoConfiguration() {

    @Bean
    fun mongoClient(): MongoClient =
        MongoClients.create(
            MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.JAVA_LEGACY)
                .applyConnectionString(ConnectionString("mongodb://order:order@localhost:27018"))
                .build()
        )

    override fun getDatabaseName() = "dborderquery"

    override fun reactiveMongoClient() = mongoClient()
}