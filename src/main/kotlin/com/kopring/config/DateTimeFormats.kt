package com.kopring.config

import java.time.format.DateTimeFormatter

/**
 * 날짜/시간 포맷 관련 공통 설정입니다.
 *
 * 애플리케이션 전역에서 사용할 날짜/시간 포맷을 정의합니다.
 * 컨트롤러의 @DateTimeFormat 어노테이션에서 이 상수를 사용할 수 있습니다.
 */
object DateTimeFormats {
    /**
     * API 요청/응답에서 사용하는 기본 날짜/시간 포맷
     */
    const val DEFAULT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss"

    /**
     * 기본 포맷터
     */
    val DEFAULT_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN)
}
