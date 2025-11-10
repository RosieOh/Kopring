package com.kopring.dto.api

import com.kopring.dto.projection.PostSummaryDto

/**
 * 게시글 목록 응답 DTO (전체 정보)
 */
data class PostListResponse(
    val posts: List<PostResponse>,
    val total: Long,
)

/**
 * 게시글 목록 응답 DTO (요약 정보 - Projection 사용)
 */
data class PostSummaryListResponse(
    val posts: List<PostSummaryDto>,
    val total: Long,
)
