package uz.hamroh.feature.authorization.ui.login

import uz.hamroh.ui.util.ValidationResult

data class LoginState(
    val email: ValidationResult = ValidationResult(),
    val password: ValidationResult = ValidationResult(),
    val error: String = ""
)
