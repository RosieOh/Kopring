package com.kopring.common.response

import org.springframework.data.domain.Page

/**
 * 페이징 응답 포맷
 *
 * 페이징된 데이터를 일관된 형태로 제공합니다.
 *
 * @param T 데이터 타입
 * @property content 데이터 목록
 * @property totalElements 전체 요소 수
 * @property totalPages 전체 페이지 수
 * @property currentPage 현재 페이지 (0부터 시작)
 * @property size 페이지 크기
 * @property hasNext 다음 페이지 존재 여부
 * @property hasPrevious 이전 페이지 존재 여부
 */
data class PageResponse<T>(
    val content: List<T>,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val size: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean,
) {
    companion object {
        /**
         * Spring Data Page를 PageResponse로 변환
         */
        fun <T> from(page: Page<T>): PageResponse<T> =
            PageResponse(
                content = page.content,
                totalElements = page.totalElements,
                totalPages = page.totalPages,
                currentPage = page.number,
                size = page.size,
                hasNext = page.hasNext(),
                hasPrevious = page.hasPrevious(),
            )

        /**
         * 리스트와 페이징 정보로 PageResponse 생성
         */
        fun <T> of(
            content: List<T>,
            totalElements: Long,
            currentPage: Int,
            size: Int,
        ): PageResponse<T> {
            val totalPages =
                if (size > 0) {
                    (totalElements / size + if (totalElements % size > 0) 1 else 0).toInt()
                } else {
                    0
                }
            return PageResponse(
                content = content,
                totalElements = totalElements,
                totalPages = totalPages,
                currentPage = currentPage,
                size = size,
                hasNext = currentPage < totalPages - 1,
                hasPrevious = currentPage > 0,
            )
        }
    }
}
