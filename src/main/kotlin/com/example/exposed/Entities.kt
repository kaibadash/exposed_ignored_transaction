package com.example.exposed
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime

object Article : Table() {
    val id = integer("id").autoIncrement()
    val userId = (integer("user_id") references User.id)
    val title = varchar("title", length = 255)
    val headline = varchar("headline", length = 255)
    val content = varchar("content", length = 255)
    val slug = varchar("slug", length = 255)
    val addedAt = datetime("added_at")
    override val primaryKey = PrimaryKey(id)
}

object User : Table() {
    val id = integer("id").autoIncrement()
    val login = varchar("login", length = 255)
    val firstname = varchar("firstname", length = 255)
    val lastname = varchar("lastname", length = 255)
    val description = varchar("description", length = 255).nullable()
    override val primaryKey = PrimaryKey(id)
}
