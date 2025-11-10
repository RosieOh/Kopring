package com.kopring.dto.projection

import com.kopring.domain.Post
import java.time.LocalDateTime

/**
 * 게시글 목록 조회용 Projection DTO
 * 내용(content)을 제외하여 성능 최적화 및 네트워크 트래픽 감소
 */
data class PostSummaryDto(
    val id: Long,
    val title: String,
    val author: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    companion object {
        fun from(post: Post): PostSummaryDto =
            PostSummaryDto(
                id = post.id!!,
                title = post.title,
                author = post.author,
                createdAt = post.createdAt,
                updatedAt = post.updatedAt,
            )
    }
}
