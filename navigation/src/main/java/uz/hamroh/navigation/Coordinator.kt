package uz.hamroh.navigation

interface Coordinator {
    fun navigateToRegister()
    fun navigateToLogin()
    fun navigateToResetPassword()
    fun navigateToEmailVerification()
    fun navigateToAuthSelection()
}