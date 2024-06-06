package uz.hamroh.feature.authorization.ui.sign_up

import uz.hamroh.feature.authorization.ui.reset_password.RestoreEffect

interface SignUpEffect {
    data object OnNavigateToLogin: SignUpEffect

    data object OnAccountExist: SignUpEffect

    data object OnNavigateToGoogleAuth: SignUpEffect
    data object OnNavigateBack: SignUpEffect

    data object OnRoundCheckBoxChanged: SignUpEffect

    data object OnSnackBarDisplayed: SignUpEffect

    data class OnEmailChange(val email: String): SignUpEffect

    data class OnPasswordChange(val password: String): SignUpEffect
}