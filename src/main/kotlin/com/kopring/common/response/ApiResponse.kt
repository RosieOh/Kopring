package com.kopring.common.response

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

/**
 * 공통 API 응답 포맷
 *
 * 모든 API 응답을 일관된 형태로 제공합니다.
 *
 * @param T 응답 데이터 타입
 * @property success 성공 여부
 * @property data 응답 데이터 (성공 시)
 * @property message 응답 메시지
 * @property code 응답 코드 (HTTP 상태 코드 또는 커스텀 코드)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null,
    val code: String? = null,
) {
    companion object {
        /**
         * 성공 응답 생성
         */
        fun <T> success(
            data: T,
            message: String? = null,
        ): ApiResponse<T> =
            ApiResponse(
                success = true,
                data = data,
                message = message,
            )

        /**
         * 성공 응답 생성 (데이터 없음)
         */
        fun success(message: String = "요청이 성공적으로 처리되었습니다."): ApiResponse<Unit> =
            ApiResponse(
                success = true,
                data = null,
                message = message,
            )

        /**
         * 실패 응답 생성
         */
        fun <T> failure(
            message: String,
            code: String? = null,
        ): ApiResponse<T> =
            ApiResponse(
                success = false,
                data = null,
                message = message,
                code = code,
            )

        /**
         * HTTP 상태 코드 기반 실패 응답 생성
         */
        fun <T> failure(
            message: String,
            status: HttpStatus,
        ): ApiResponse<T> =
            ApiResponse(
                success = false,
                data = null,
                message = message,
                code = status.name,
            )
    }
}
