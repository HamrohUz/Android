package uz.hamroh.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import uz.hamroh.feature.authorization.ui.auth_selection.AuthSelectionFragment
import uz.hamroh.feature.authorization.ui.email_verification.EmailVerificationFragment
import uz.hamroh.feature.authorization.ui.login.LoginFragment
import uz.hamroh.feature.authorization.ui.reset_password.ResetPasswordFragment
import uz.hamroh.feature.authorization.ui.sign_up.SignUpFragment

object Screens {
    fun SignUp() = FragmentScreen { SignUpFragment() }

    fun Login() = FragmentScreen { LoginFragment() }

    fun ResetPassword() = FragmentScreen { ResetPasswordFragment() }

    fun EmailVerification() = FragmentScreen { EmailVerificationFragment() }

    fun AuthSelection() = FragmentScreen { AuthSelectionFragment() }

}