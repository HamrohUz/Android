package uz.hamroh.feature.authorization.ui.sign_up

import uz.hamroh.ui.util.ValidationResult

data class SignUpState(
    val email: ValidationResult = ValidationResult(),
    val password: ValidationResult = ValidationResult(),
    val isCheckedPolicy: Boolean = false,
    val error: String = ""
)
