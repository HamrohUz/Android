package uz.hamroh.ui.util

import android.util.Patterns

object Validator {

    private val EMAIL_ADDRESS_PATTERN = Patterns.EMAIL_ADDRESS
    fun validateEmail(email: String): ValidationResult {
        return if (email.isEmpty()) {
            ValidationResult(email, ValidationResultType.EMPTY)
        } else if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            ValidationResult(email, ValidationResultType.EMAIL_IS_NOT_CORRECT)
        } else {
            ValidationResult(email, ValidationResultType.ACCEPTED)
        }
    }
    fun validatePassword(password: String): ValidationResult {
        if (password.isEmpty()) {
            return ValidationResult(password, ValidationResultType.EMPTY)
        }
        if (password.length < 8) {
            return ValidationResult(password, ValidationResultType.LENGTH_SHORT)
        }
        if (!password.any { it.isUpperCase() }) {
            return ValidationResult(password, ValidationResultType.AT_LEAST_ONE_UPPER_CASE_SYMBOL)
        }
        if (!password.any { it.isDigit() }) {
            return ValidationResult(password, ValidationResultType.AT_LEAST_ONE_NUMBER)
        }
        return ValidationResult(password, ValidationResultType.ACCEPTED)
    }

}