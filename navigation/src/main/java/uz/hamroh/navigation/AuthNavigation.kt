package uz.hamroh.navigation

interface AuthNavigation {
    fun navigateToAuthSelection()

    fun navigateToLogin()

    fun replaceToLogin()

    fun navigateToRestorePassword()

    fun navigateToSignUp()

    fun navigateToEmailVerification(email: String, password: String, routeIntent: RouteIntent = RouteIntent.VerifyEmail)

    fun navigateToAuthStatus(title: String, message: String)

    fun navigateBack()
}