package com.kopring.common.example

import com.kopring.common.response.ApiResponse
import com.kopring.common.response.PageResponse
import com.kopring.common.util.DateTimeUtils
import com.kopring.common.util.PageableUtils
import com.kopring.common.util.ResponseEntityUtils
import com.kopring.common.util.StringUtils
import com.kopring.common.util.ValidationUtils
import com.kopring.common.constants.ApiConstants
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity

/**
 * 공통 모듈 사용 예시
 *
 * 이 파일은 공통 모듈의 사용 방법을 보여주는 예시입니다.
 * 실제 프로덕션 코드에서는 이 파일을 삭제하거나 참고용으로만 사용하세요.
 */
object CommonModuleExample {
    /**
     * ApiResponse 사용 예시
     */
    fun apiResponseExample() {
        // 성공 응답 (데이터 포함)
        val successResponse: ApiResponse<String> = ApiResponse.success("데이터", "성공 메시지")

        // 성공 응답 (데이터 없음)
        val successNoData: ApiResponse<Unit> = ApiResponse.success("처리 완료")

        // 실패 응답
        val failureResponse: ApiResponse<Unit> = ApiResponse.failure("에러 메시지", "ERROR_CODE")
    }

    /**
     * ResponseEntityUtils 사용 예시
     */
    fun responseEntityExample(): ResponseEntity<ApiResponse<String>> {
        // 성공 응답 (200 OK)
        return ResponseEntityUtils.ok("데이터", "성공 메시지")

        // 생성 성공 응답 (201 Created)
        // return ResponseEntityUtils.created("생성된 데이터")

        // 수정 성공 응답 (200 OK)
        // return ResponseEntityUtils.updated("수정된 데이터")

        // 삭제 성공 응답 (204 No Content)
        // return ResponseEntityUtils.deleted()

        // 실패 응답
        // return ResponseEntityUtils.failure("에러 메시지")
    }

    /**
     * PageResponse 사용 예시
     */
    fun pageResponseExample(page: Page<String>): PageResponse<String> {
        // Spring Data Page를 PageResponse로 변환
        return PageResponse.from(page)
    }

    /**
     * PageableUtils 사용 예시
     */
    fun pageableExample() {
        // 기본 페이징 정보 생성
        val pageable =
            PageableUtils.createPageable(
                page = 0,
                size = 10,
                sortBy = "createdAt",
            )

        // 페이징 파라미터 검증
        val (validatedPage, validatedSize) = PageableUtils.validatePageable(0, 20)
    }

    /**
     * StringUtils 사용 예시
     */
    fun stringUtilsExample() {
        // 문자열 검증
        val isBlank = StringUtils.isBlank("") // true
        val isNotEmpty = StringUtils.isNotEmpty("text") // true

        // 문자열 자르기
        val truncated = StringUtils.truncate("긴 문자열입니다", 5) // "긴 문자열..."

        // 문자열 연결
        val joined = StringUtils.join("a", "b", "c", delimiter = ", ") // "a, b, c"
    }

    /**
     * DateTimeUtils 사용 예시
     */
    fun dateTimeUtilsExample() {
        val now = DateTimeUtils.now()

        // 포맷팅
        val formatted = DateTimeUtils.format(now) // ISO 형식
        val koreanFormat = DateTimeUtils.formatKorean(now) // "2024-01-01 12:00:00"

        // 파싱
        val parsed = DateTimeUtils.parse("2024-01-01T12:00:00")

        // 차이 계산
        val diff = DateTimeUtils.diffInMinutes(now, now.plusHours(1)) // 60
    }

    /**
     * ValidationUtils 사용 예시
     */
    fun validationUtilsExample() {
        // 이메일 검증
        val isValidEmail = ValidationUtils.isValidEmail("test@example.com") // true

        // 전화번호 검증
        val isValidPhone = ValidationUtils.isValidPhoneNumber("010-1234-5678") // true

        // URL 검증
        val isValidUrl = ValidationUtils.isValidUrl("https://example.com") // true

        // 비밀번호 강도 검증
        val isStrong = ValidationUtils.isStrongPassword("Password123!") // true
    }

    /**
     * ApiConstants 사용 예시
     */
    fun apiConstantsExample() {
        val basePath = ApiConstants.API_BASE_PATH // "/api"
        val defaultPageSize = ApiConstants.DEFAULT_PAGE_SIZE // 10
        val maxPageSize = ApiConstants.MAX_PAGE_SIZE // 100
    }
}
