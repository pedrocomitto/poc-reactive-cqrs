package com.pedrocomitto.poc.orderquery.config

import com.datastax.oss.driver.api.core.config.DefaultDriverOption
import com.datastax.oss.driver.api.core.config.ProgrammaticDriverConfigLoaderBuilder
import org.springframework.boot.autoconfigure.cassandra.DriverConfigLoaderBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories
import java.time.Duration


@Configuration
@EnableReactiveCassandraRepositories
class CassandraConfig : AbstractReactiveCassandraConfiguration() {

    @Bean
    fun cassandraDriverCustomizer(): DriverConfigLoaderBuilderCustomizer? {
        return DriverConfigLoaderBuilderCustomizer { builder: ProgrammaticDriverConfigLoaderBuilder ->
            builder.withDuration(
                DefaultDriverOption.CONTROL_CONNECTION_TIMEOUT, Duration.ofSeconds(10)
            )
        }
    }

    override fun getContactPoints(): String {
        return "localhost"
    }

    override fun getKeyspaceName(): String {
        return "orderquery"
    }

    override fun getKeyspaceCreations() =
        listOf(
            CreateKeyspaceSpecification
                .createKeyspace("orderquery")
                .ifNotExists()
                .withSimpleReplication()
        )

    override fun getSchemaAction() =
        SchemaAction.CREATE_IF_NOT_EXISTS
}