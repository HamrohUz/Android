package uz.hamroh.navigation

import com.github.terrakok.cicerone.Router

class AppCoordinator(private val router: Router) : Coordinator {

    override fun navigateToAuthSelection() {
        router.replaceScreen(Screens.AuthSelection())
    }
    override fun navigateToRegister() {
        router.navigateTo(Screens.SignUp())
    }
    override fun navigateToLogin() {
        router.navigateTo(Screens.Login())
    }
    override fun navigateToEmailVerification() {
        router.navigateTo(Screens.EmailVerification())
    }
    override fun navigateToResetPassword() {
        router.navigateTo(Screens.ResetPassword())
    }

}