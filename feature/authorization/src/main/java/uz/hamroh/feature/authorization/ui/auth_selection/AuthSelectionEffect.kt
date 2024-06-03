package uz.hamroh.feature.authorization.ui.auth_selection

sealed interface AuthSelectionEffect {
    data object NavigateToSignUp: AuthSelectionEffect
    data object NavigateToLogin: AuthSelectionEffect
}