package com.example.exposed

import org.jetbrains.exposed.sql.SchemaUtils
import java.time.LocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.Transactional

@Configuration
@Transactional
class MyConfiguration {

    @Bean
    fun databaseInitializer() = ApplicationRunner {
        transaction {
            SchemaUtils.create (User, Article)
        }
    }
}
