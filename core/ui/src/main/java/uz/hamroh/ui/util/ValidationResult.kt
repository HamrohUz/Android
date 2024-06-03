package uz.hamroh.ui.util

data class ValidationResult(
    val value: String = "",
    val acceptance: ValidationResultType = ValidationResultType.ACCEPTED,
) {

    val isAccepted: Boolean
        get() = acceptance == ValidationResultType.ACCEPTED

    val isNotEmptyAccepted: Boolean
        get() = isAccepted && value.isNotEmpty()
}
