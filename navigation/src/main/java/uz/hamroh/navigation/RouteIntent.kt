package uz.hamroh.navigation

sealed interface RouteIntent {
    data object RecoverPassword: RouteIntent
    data object VerifyEmail: RouteIntent
}