package uz.hamroh.feature.authorization.ui.reset_password

sealed interface RestoreEffect {
    data object OnNavigateToOtp: RestoreEffect
    data object OnNavigateToPrevious: RestoreEffect
    data class OnPasswordChange(val password: String): RestoreEffect
    data class OnEmailChange(val email: String): RestoreEffect
    data object OnSnackBarDisplayed: RestoreEffect

}