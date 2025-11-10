package com.kopring.common.annotation

import com.kopring.common.constants.ApiConstants

/**
 * 페이징 파라미터 기본값을 위한 어노테이션
 *
 * 컨트롤러 메서드의 페이징 파라미터에 사용할 수 있습니다.
 */
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class PageableParams(
    val defaultPage: Int = ApiConstants.DEFAULT_PAGE_NUMBER,
    val defaultSize: Int = ApiConstants.DEFAULT_PAGE_SIZE,
    val maxSize: Int = ApiConstants.MAX_PAGE_SIZE,
)
