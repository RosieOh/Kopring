package com.kopring.dto.api

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * 게시글 생성 요청 DTO
 */
data class PostCreateRequest(
    @field:NotBlank(message = "제목은 필수입니다.")
    @field:Size(max = 200, message = "제목은 200자 이하여야 합니다.")
    val title: String,
    @field:NotBlank(message = "내용은 필수입니다.")
    val content: String,
    @field:NotBlank(message = "작성자는 필수입니다.")
    @field:Size(max = 50, message = "작성자는 50자 이하여야 합니다.")
    val author: String,
)

/**
 * 게시글 수정 요청 DTO
 */
data class PostUpdateRequest(
    @field:NotBlank(message = "제목은 필수입니다.")
    @field:Size(max = 200, message = "제목은 200자 이하여야 합니다.")
    val title: String,
    @field:NotBlank(message = "내용은 필수입니다.")
    val content: String,
)
