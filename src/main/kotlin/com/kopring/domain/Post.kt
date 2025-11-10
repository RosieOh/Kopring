package com.kopring.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

/**
 * 게시글 엔티티
 */
@Entity
@Table(name = "posts")
class Post(
    @Column(nullable = false, length = 200)
    var title: String,
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,
    @Column(nullable = false, length = 50)
    var author: String,
) : BaseEntity() {
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()

    fun update(
        title: String,
        content: String,
    ) {
        this.title = title
        this.content = content
        this.updatedAt = LocalDateTime.now()
    }
}
