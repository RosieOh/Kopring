package com.kopring.dto.api

import com.kopring.domain.Post
import java.time.LocalDateTime

/**
 * 게시글 응답 DTO
 */
data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun from(post: Post): PostResponse =
            PostResponse(
                id = post.id!!,
                title = post.title,
                content = post.content,
                author = post.author,
                createdAt = post.createdAt,
                updatedAt = post.updatedAt,
            )
    }
}
