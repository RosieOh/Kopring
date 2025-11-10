package com.kopring.common.util

import com.kopring.common.constants.ApiConstants
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

/**
 * 페이징 유틸리티
 */
object PageableUtils {
    /**
     * 기본 정렬 필드
     */
    const val DEFAULT_SORT_FIELD = "createdAt"

    /**
     * 기본 페이징 정보 생성
     */
    fun createPageable(
        page: Int? = null,
        size: Int? = null,
        sortBy: String = DEFAULT_SORT_FIELD,
        direction: Sort.Direction = Sort.Direction.DESC,
    ): Pageable {
        val pageNumber = page?.coerceAtLeast(0) ?: ApiConstants.DEFAULT_PAGE_NUMBER
        val pageSize = size?.coerceIn(1, ApiConstants.MAX_PAGE_SIZE) ?: ApiConstants.DEFAULT_PAGE_SIZE
        return PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortBy))
    }

    /**
     * 정렬 방향 문자열을 Sort.Direction으로 변환
     */
    fun parseSortDirection(direction: String?): Sort.Direction =
        when (direction?.uppercase()) {
            "ASC" -> Sort.Direction.ASC
            "DESC" -> Sort.Direction.DESC
            else -> Sort.Direction.DESC
        }

    /**
     * 페이징 파라미터 검증
     */
    fun validatePageable(
        page: Int?,
        size: Int?,
    ): Pair<Int, Int> {
        val pageNumber = page?.coerceAtLeast(0) ?: ApiConstants.DEFAULT_PAGE_NUMBER
        val pageSize = size?.coerceIn(1, ApiConstants.MAX_PAGE_SIZE) ?: ApiConstants.DEFAULT_PAGE_SIZE
        return Pair(pageNumber, pageSize)
    }
}
