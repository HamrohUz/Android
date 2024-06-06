package uz.hamroh.feature.authorization.ui.email_verification

data class EmailVerificationState(
    val code: String = "",
    val isOtpCorrect: Boolean = false,
    val error: String = "",
    val expectedOtp: String = "",
    val isOtpFilled: Boolean = false,
    val email: String = "",
)
