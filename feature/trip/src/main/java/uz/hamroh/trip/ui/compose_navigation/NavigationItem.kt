package uz.hamroh.trip.ui.compose_navigation

sealed class NavigationItem(var route: String, val icon: Int) {
    data object Home : NavigationItem(
        MainScreen.HOME,
        uz.hamroh.ui.R.drawable.ic_car_24,
    )

    data object TripHistory : NavigationItem(
        MainScreen.TRIP_HISTORY,
        uz.hamroh.ui.R.drawable.ic_trip_history_24,
    )

    data object Profile : NavigationItem(
        MainScreen.PROFILE,
        uz.hamroh.ui.R.drawable.ic_profile_24,
    )
    data object Chat : NavigationItem(
        MainScreen.CHATS,
        uz.hamroh.ui.R.drawable.ic_chat_24,
    )
}