package com.kopring.exception

/**
 * ErrorCode를 도메인별로 그룹화하기 위한 객체입니다.
 *
 * 기존 ErrorCode enum은 유지하되, 도메인별로 분류하여 관리합니다.
 */
object ErrorCodeGroup {
    /**
     * 시스템 관련 에러 코드
     */
    object System {
        val RUNTIME_EXCEPTION = ErrorCode.RUNTIME_EXCEPTION
        val INTERNAL_SERVER_ERROR = ErrorCode.INTERNAL_SERVER_ERROR
    }

    /**
     * 공통 에러 코드
     */
    object Common {
        val BAD_REQUEST = ErrorCode.BAD_REQUEST
        val VALID_FAILED = ErrorCode.VALID_FAILED
    }

    /**
     * 게시판 관련 에러 코드
     */
    object Post {
        val POST_NOT_FOUND = ErrorCode.POST_NOT_FOUND
    }
}
