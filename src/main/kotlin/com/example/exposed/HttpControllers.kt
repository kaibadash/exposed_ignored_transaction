package com.example.exposed

import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/test")
class ArticleController() {

    @GetMapping("/")
    // @Transactional
    fun test(): List<String> {
        transaction {
            addLogger(StdOutSqlLogger)
            User.insert {
                it[login] = "no1_" + java.lang.Math.random()
                it[firstname] = "one"
                it[lastname] = "one"
                it[description] = Date().toString()
            }
        }
        /* TODO: something important process... */
        transaction {
            addLogger(StdOutSqlLogger)
            User.insert {
                it[login] = "no2_" + java.lang.Math.random()
                it[firstname] = "two"
                it[lastname] = "two"
                it[description] = Date().toString()
            }
        }
        return listOf<String>("test")
    }
}
