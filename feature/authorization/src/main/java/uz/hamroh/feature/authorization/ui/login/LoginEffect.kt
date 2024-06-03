package uz.hamroh.feature.authorization.ui.login

sealed interface LoginEffect {
    data object NavigateToPrevious: LoginEffect

    data object NavigateToSignUp: LoginEffect
    data object NavigateToRestorePassword: LoginEffect

    data object NavigateToNext: LoginEffect

    data object NavigateToGoogleAuth: LoginEffect

    data class OnEmailValueChange(val value: String): LoginEffect

    data class OnPasswordValueChange(val value: String): LoginEffect

    data object OnSnackBarDisplayed: LoginEffect
}