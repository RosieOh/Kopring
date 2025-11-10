package com.kopring.common.util

/**
 * 문자열 유틸리티
 */
object StringUtils {
    /**
     * 문자열이 비어있거나 공백만 있는지 확인
     */
    fun isBlank(str: String?): Boolean = str.isNullOrBlank()

    /**
     * 문자열이 비어있는지 확인 (null 또는 빈 문자열)
     */
    fun isEmpty(str: String?): Boolean = str.isNullOrEmpty()

    /**
     * 문자열이 비어있지 않은지 확인
     */
    fun isNotBlank(str: String?): Boolean = !str.isNullOrBlank()

    /**
     * 문자열이 비어있지 않은지 확인
     */
    fun isNotEmpty(str: String?): Boolean = !str.isNullOrEmpty()

    /**
     * 문자열을 안전하게 자르기 (null 체크 포함)
     */
    fun truncate(
        str: String?,
        maxLength: Int,
    ): String? {
        if (str == null) return null
        return if (str.length <= maxLength) str else str.substring(0, maxLength) + "..."
    }

    /**
     * 여러 문자열을 구분자로 연결
     */
    fun join(
        vararg strings: String?,
        delimiter: String = ", ",
    ): String = strings.filterNotNull().joinToString(delimiter)

    /**
     * 문자열에서 HTML 태그 제거
     */
    fun stripHtml(html: String?): String? {
        if (html == null) return null
        return html.replace(Regex("<[^>]*>"), "")
    }
}
