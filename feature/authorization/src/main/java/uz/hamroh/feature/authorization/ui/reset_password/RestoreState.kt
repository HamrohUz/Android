package uz.hamroh.feature.authorization.ui.reset_password

import uz.hamroh.ui.util.ValidationResult

data class RestoreState(
    val email: ValidationResult = ValidationResult(),
    val password: ValidationResult = ValidationResult(),
)
