package com.kopring.service

import com.kopring.domain.Post
import com.kopring.dto.api.PostCreateRequest
import com.kopring.dto.api.PostListResponse
import com.kopring.dto.api.PostResponse
import com.kopring.dto.api.PostSummaryListResponse
import com.kopring.dto.api.PostUpdateRequest
import com.kopring.exception.CustomException
import com.kopring.exception.ErrorCode
import com.kopring.repository.PostRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 게시글 서비스
 */
@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
) {
    /**
     * 게시글 생성
     */
    @Transactional
    fun createPost(request: PostCreateRequest): PostResponse {
        val post =
            Post(
                title = request.title,
                content = request.content,
                author = request.author,
            )
        val savedPost = postRepository.save(post)
        return PostResponse.from(savedPost)
    }

    /**
     * 게시글 조회
     */
    fun getPost(id: Long): PostResponse {
        val post =
            postRepository
                .findById(id)
                .orElseThrow { CustomException(ErrorCode.POST_NOT_FOUND) }
        return PostResponse.from(post)
    }

    /**
     * 게시글 목록 조회 (페이징 - 전체 정보)
     */
    fun getPosts(
        page: Int,
        size: Int,
    ): PostListResponse {
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"))
        val postPage = postRepository.findAllByOrderByCreatedAtDesc(pageable)
        val posts = postPage.content.map { PostResponse.from(it) }
        return PostListResponse(
            posts = posts,
            total = postPage.totalElements,
        )
    }

    /**
     * 게시글 목록 조회 (페이징 - Projection 사용, 내용 제외)
     * 성능 최적화를 위해 필요한 필드만 조회
     */
    fun getPostSummaries(
        page: Int,
        size: Int,
    ): PostSummaryListResponse {
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"))
        val postPage = postRepository.findAllSummariesByOrderByCreatedAtDesc(pageable)
        return PostSummaryListResponse(
            posts = postPage.content,
            total = postPage.totalElements,
        )
    }

    /**
     * 게시글 수정
     */
    @Transactional
    fun updatePost(
        id: Long,
        request: PostUpdateRequest,
    ): PostResponse {
        val post =
            postRepository
                .findById(id)
                .orElseThrow { CustomException(ErrorCode.POST_NOT_FOUND) }
        post.update(request.title, request.content)
        return PostResponse.from(post)
    }

    /**
     * 게시글 삭제
     */
    @Transactional
    fun deletePost(id: Long) {
        if (!postRepository.existsById(id)) {
            throw CustomException(ErrorCode.POST_NOT_FOUND)
        }
        postRepository.deleteById(id)
    }
}
