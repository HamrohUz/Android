package uz.hamroh.navigation

interface AuthNavigation {
    fun navigateToAuthSelection()

    fun navigateToLogin()

    fun navigateToRestorePassword()

    fun navigateToSignUp()

    fun navigateToEmailVerification()

    fun navigateBack()
}