package uz.hamroh.feature.authorization.ui.email_verification

import uz.hamroh.feature.authorization.ui.login.LoginEffect

interface EmailVerificationEffect {
    data object OnNavigateToPrevious: EmailVerificationEffect
    data object OnConfirm: EmailVerificationEffect

    data object OnSnackBarDisplayed: EmailVerificationEffect
    data class OnOtpCodeChange(val text: String): EmailVerificationEffect
}