package com.kopring.repository

import com.kopring.domain.Post
import com.kopring.dto.projection.PostSummaryDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * 게시글 리포지토리
 */
interface PostRepository : JpaRepository<Post, Long> {
    fun findAllByOrderByCreatedAtDesc(pageable: Pageable): Page<Post>

    /**
     * 게시글 목록 조회 (Projection 사용 - 내용 제외)
     * 성능 최적화를 위해 필요한 필드만 조회
     */
    @Query(
        """
        SELECT new com.kopring.dto.projection.PostSummaryDto(
            p.id, p.title, p.author, p.createdAt, p.updatedAt
        )
        FROM Post p
        ORDER BY p.createdAt DESC
    """,
    )
    fun findAllSummariesByOrderByCreatedAtDesc(pageable: Pageable): Page<PostSummaryDto>
}
