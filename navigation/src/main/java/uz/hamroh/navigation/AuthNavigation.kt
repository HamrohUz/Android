package uz.hamroh.navigation

interface AuthNavigation {
    fun navigateToAuthSelection()

    fun navigateToLogin()

    fun navigateToRestorePassword()

    fun navigateToSignUp()

    fun navigateToEmailVerification(email: String, routeIntent: RouteIntent = RouteIntent.VerifyEmail)

    fun navigateToAuthStatus(title: String, message: String)

    fun navigateBack()
}