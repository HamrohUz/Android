package uz.hamroh.feature.authorization.ui.auth_selection

import dagger.hilt.android.lifecycle.HiltViewModel
import uz.hamroh.feature.authorization.data.AuthApi
import uz.hamroh.navigation.AuthNavigation
import uz.hamroh.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class AuthSelectionViewModel @Inject constructor(
    private val authNavigation: AuthNavigation
) : BaseViewModel<AuthSelectionState, AuthSelectionEffect>(
    AuthSelectionState()
) {
    fun onNavigateToRegistration() {
        authNavigation.navigateToSignUp()
    }

    fun onNavigateToLogin() {
        authNavigation.navigateToLogin()
    }
}