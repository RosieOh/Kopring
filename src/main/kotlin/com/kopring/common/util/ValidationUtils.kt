package com.kopring.common.util

/**
 * 유효성 검증 유틸리티
 */
object ValidationUtils {
    /**
     * 이메일 형식 검증
     */
    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return false
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
        return email.matches(Regex(emailRegex))
    }

    /**
     * 전화번호 형식 검증 (한국 형식: 010-1234-5678 또는 01012345678)
     */
    fun isValidPhoneNumber(phone: String?): Boolean {
        if (phone.isNullOrBlank()) return false
        val phoneRegex = "^01[0-9]-?[0-9]{3,4}-?[0-9]{4}\$"
        return phone.replace("-", "").matches(Regex(phoneRegex))
    }

    /**
     * URL 형식 검증
     */
    fun isValidUrl(url: String?): Boolean {
        if (url.isNullOrBlank()) return false
        val urlRegex = "^https?://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?\$"
        return url.matches(Regex(urlRegex))
    }

    /**
     * 숫자만 포함하는지 검증
     */
    fun isNumeric(str: String?): Boolean {
        if (str.isNullOrBlank()) return false
        return str.all { it.isDigit() }
    }

    /**
     * 문자열 길이 검증
     */
    fun isValidLength(
        str: String?,
        min: Int,
        max: Int,
    ): Boolean {
        if (str == null) return false
        return str.length in min..max
    }

    /**
     * 비밀번호 강도 검증 (최소 8자, 영문+숫자+특수문자 포함)
     */
    fun isStrongPassword(password: String?): Boolean {
        if (password.isNullOrBlank()) return false
        if (password.length < 8) return false
        val hasLetter = password.any { it.isLetter() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecial = password.any { !it.isLetterOrDigit() }
        return hasLetter && hasDigit && hasSpecial
    }
}
