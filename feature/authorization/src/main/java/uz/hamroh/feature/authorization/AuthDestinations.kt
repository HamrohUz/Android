package uz.hamroh.feature.authorization

import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.hamroh.feature.authorization.AuthScreens.AuthSelection
import uz.hamroh.feature.authorization.AuthScreens.EmailVerification
import uz.hamroh.feature.authorization.AuthScreens.Login
import uz.hamroh.feature.authorization.AuthScreens.RestorePassword
import uz.hamroh.feature.authorization.AuthScreens.SignUp
import uz.hamroh.feature.authorization.ui.auth_selection.AuthSelectionFragment
import uz.hamroh.feature.authorization.ui.email_verification.EmailVerificationFragment
import uz.hamroh.feature.authorization.ui.login.LoginFragment
import uz.hamroh.feature.authorization.ui.reset_password.ResetPasswordFragment
import uz.hamroh.feature.authorization.ui.sign_up.SignUpFragment
import uz.hamroh.navigation.AppCoordinator
import uz.hamroh.navigation.AuthNavigation
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun provideAuth(appCoordinator: AppCoordinator): AuthNavigation =
        AuthNavigationImpl(appCoordinator)
}

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

    override fun navigateToEmailVerification() {
        appCoordinator.navigateTo(EmailVerification())
    }

    override fun navigateBack() {
        appCoordinator.backToPreviousScreen()
    }

}

object AuthScreens {
    fun AuthSelection() = FragmentScreen { AuthSelectionFragment() }

    fun Login() = FragmentScreen { LoginFragment() }

    fun RestorePassword() = FragmentScreen { ResetPasswordFragment() }

    fun SignUp() = FragmentScreen { SignUpFragment() }

    fun EmailVerification() = FragmentScreen { EmailVerificationFragment() }
}