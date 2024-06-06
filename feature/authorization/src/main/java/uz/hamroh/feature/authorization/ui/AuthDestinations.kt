package uz.hamroh.feature.authorization.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import uz.hamroh.feature.authorization.ui.AuthScreens.AuthSelection
import uz.hamroh.feature.authorization.ui.AuthScreens.AuthStatus
import uz.hamroh.feature.authorization.ui.AuthScreens.EmailVerification
import uz.hamroh.feature.authorization.ui.AuthScreens.Login
import uz.hamroh.feature.authorization.ui.AuthScreens.RestorePassword
import uz.hamroh.feature.authorization.ui.AuthScreens.SignUp
import uz.hamroh.feature.authorization.ui.auth_selection.AuthSelectionFragment
import uz.hamroh.feature.authorization.ui.auth_status.AuthStatusFragment
import uz.hamroh.feature.authorization.ui.email_verification.EmailVerificationFragment
import uz.hamroh.feature.authorization.ui.login.LoginFragment
import uz.hamroh.feature.authorization.ui.reset_password.RestorePasswordFragment
import uz.hamroh.feature.authorization.ui.sign_up.SignUpFragment
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.navigation.RouteIntent

class AuthNavigationImpl(private val appCoordinator: AppCoordinator) : AuthNavigation {
    override fun navigateToAuthSelection() {
        appCoordinator.replace(AuthSelection())
    }

    override fun navigateToLogin() {
        appCoordinator.navigateTo(Login())
    }

    override fun navigateToRestorePassword() {
        appCoordinator.navigateTo(RestorePassword())
    }

    override fun navigateToSignUp() {
        appCoordinator.navigateTo(SignUp())
    }

    override fun navigateToEmailVerification(email: String, password: String, routeIntent: RouteIntent ) {
        appCoordinator.navigateTo(EmailVerification(email, password, routeIntent))
    }

    override fun navigateToAuthStatus(title: String, message: String) {
        appCoordinator.navigateTo(AuthStatus(title, message))
    }

    override fun replaceToLogin() {
        appCoordinator.replace(Login())
    }

    override fun navigateBack() {
        appCoordinator.backToPreviousScreen()
    }
}

object AuthScreens {
    fun AuthSelection() = FragmentScreen { AuthSelectionFragment() }

    fun AuthStatus(title: String, message: String) = FragmentScreen { AuthStatusFragment(title, message) }

    fun Login() = FragmentScreen { LoginFragment() }

    fun RestorePassword() = FragmentScreen { RestorePasswordFragment() }

    fun SignUp() = FragmentScreen { SignUpFragment() }

    fun EmailVerification(email: String, password: String, routeIntent: RouteIntent) = FragmentScreen { EmailVerificationFragment(email, password, routeIntent) }
}