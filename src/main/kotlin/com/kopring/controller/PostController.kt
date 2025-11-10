package com.kopring.controller

import com.kopring.dto.api.PostCreateRequest
import com.kopring.dto.api.PostListResponse
import com.kopring.dto.api.PostResponse
import com.kopring.dto.api.PostUpdateRequest
import com.kopring.service.PostService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * 게시판 컨트롤러
 */
@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService,
) {
    /**
     * 게시글 생성
     */
    @PostMapping
    fun createPost(
        @Valid @RequestBody request: PostCreateRequest,
    ): ResponseEntity<PostResponse> {
        val response = postService.createPost(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    /**
     * 게시글 조회
     */
    @GetMapping("/{id}")
    fun getPost(
        @PathVariable id: Long,
    ): ResponseEntity<PostResponse> {
        val response = postService.getPost(id)
        return ResponseEntity.ok(response)
    }

    /**
     * 게시글 목록 조회
     */
    @GetMapping
    fun getPosts(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
    ): ResponseEntity<PostListResponse> {
        val response = postService.getPosts(page, size)
        return ResponseEntity.ok(response)
    }

    /**
     * 게시글 수정
     */
    @PutMapping("/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @Valid @RequestBody request: PostUpdateRequest,
    ): ResponseEntity<PostResponse> {
        val response = postService.updatePost(id, request)
        return ResponseEntity.ok(response)
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    fun deletePost(
        @PathVariable id: Long,
    ): ResponseEntity<Void> {
        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }
}
