package com.kopring.common.constants

/**
 * API 경로 상수를 정의하는 객체입니다.
 */
object ApiConstants {
    const val API_BASE_PATH = "/api"
    const val POSTS_PATH = "$API_BASE_PATH/posts"

    /**
     * 기본 페이지 크기
     */
    const val DEFAULT_PAGE_SIZE = 10

    /**
     * 최대 페이지 크기
     */
    const val MAX_PAGE_SIZE = 100

    /**
     * 기본 페이지 번호
     */
    const val DEFAULT_PAGE_NUMBER = 0
}
