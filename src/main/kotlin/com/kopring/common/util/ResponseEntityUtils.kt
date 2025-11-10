package com.kopring.common.util

import com.kopring.common.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * ResponseEntity 생성 유틸리티
 *
 * API 응답을 일관된 형태로 생성하는 헬퍼 함수들을 제공합니다.
 */
object ResponseEntityUtils {
    /**
     * 성공 응답 생성 (200 OK)
     */
    fun <T> ok(
        data: T,
        message: String? = null,
    ): ResponseEntity<ApiResponse<T>> = ResponseEntity.ok(ApiResponse.success(data, message))

    /**
     * 성공 응답 생성 (데이터 없음, 200 OK)
     */
    fun ok(message: String = "요청이 성공적으로 처리되었습니다."): ResponseEntity<ApiResponse<Unit>> =
        ResponseEntity.ok(ApiResponse.success(message))

    /**
     * 생성 성공 응답 (201 Created)
     */
    fun <T> created(
        data: T,
        message: String? = null,
    ): ResponseEntity<ApiResponse<T>> =
        ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(data, message))

    /**
     * 수정 성공 응답 (200 OK)
     */
    fun <T> updated(
        data: T,
        message: String? = null,
    ): ResponseEntity<ApiResponse<T>> = ResponseEntity.ok(ApiResponse.success(data, message ?: "수정이 완료되었습니다."))

    /**
     * 삭제 성공 응답 (204 No Content)
     */
    fun deleted(): ResponseEntity<ApiResponse<Unit>> =
        ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.success("삭제가 완료되었습니다."))

    /**
     * 실패 응답 생성
     */
    fun <T> failure(
        message: String,
        status: HttpStatus = HttpStatus.BAD_REQUEST,
    ): ResponseEntity<ApiResponse<T>> = ResponseEntity.status(status).body(ApiResponse.failure(message, status))

    /**
     * 커스텀 코드를 포함한 실패 응답 생성
     */
    fun <T> failure(
        message: String,
        code: String,
        status: HttpStatus = HttpStatus.BAD_REQUEST,
    ): ResponseEntity<ApiResponse<T>> = ResponseEntity.status(status).body(ApiResponse.failure(message, code))
}
