package com.kopring.exception

import org.springframework.http.HttpStatus

/**
 * 애플리케이션 공통 커스텀 예외
 * ErrorCode 기반으로 예외를 표현합니다.
 */

enum class ErrorCode(
    val status: HttpStatus,
    val message: String,
) {
    // System Exception
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "BAD_REQUEST"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR"),

    // COMMON Custom Exception
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALID_FAILED(HttpStatus.BAD_REQUEST, "요청값이 올바르지 않습니다."),

    // PostService
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
}
