package com.kopring.common.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 날짜/시간 유틸리티
 */
object DateTimeUtils {
    /**
     * 기본 날짜/시간 포맷터 (ISO_LOCAL_DATE_TIME)
     */
    val DEFAULT_FORMATTER: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    /**
     * 한국 날짜/시간 포맷터 (yyyy-MM-dd HH:mm:ss)
     */
    val KOREAN_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    /**
     * 날짜만 포맷터 (yyyy-MM-dd)
     */
    val DATE_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    /**
     * 시간만 포맷터 (HH:mm:ss)
     */
    val TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    /**
     * LocalDateTime을 문자열로 변환 (기본 포맷)
     */
    fun format(dateTime: LocalDateTime?): String? = dateTime?.format(DEFAULT_FORMATTER)

    /**
     * LocalDateTime을 문자열로 변환 (커스텀 포맷)
     */
    fun format(
        dateTime: LocalDateTime?,
        formatter: DateTimeFormatter,
    ): String? = dateTime?.format(formatter)

    /**
     * LocalDateTime을 한국 포맷으로 변환
     */
    fun formatKorean(dateTime: LocalDateTime?): String? = dateTime?.format(KOREAN_FORMATTER)

    /**
     * 문자열을 LocalDateTime으로 파싱
     */
    fun parse(dateTimeString: String?): LocalDateTime? =
        dateTimeString?.let { LocalDateTime.parse(it, DEFAULT_FORMATTER) }

    /**
     * 문자열을 LocalDateTime으로 파싱 (커스텀 포맷)
     */
    fun parse(
        dateTimeString: String?,
        formatter: DateTimeFormatter,
    ): LocalDateTime? = dateTimeString?.let { LocalDateTime.parse(it, formatter) }

    /**
     * 현재 시간 반환
     */
    fun now(): LocalDateTime = LocalDateTime.now()

    /**
     * 두 날짜 사이의 차이 계산 (초 단위)
     */
    fun diffInSeconds(
        start: LocalDateTime,
        end: LocalDateTime,
    ): Long =
        java.time.Duration
            .between(start, end)
            .seconds

    /**
     * 두 날짜 사이의 차이 계산 (분 단위)
     */
    fun diffInMinutes(
        start: LocalDateTime,
        end: LocalDateTime,
    ): Long =
        java.time.Duration
            .between(start, end)
            .toMinutes()
}
